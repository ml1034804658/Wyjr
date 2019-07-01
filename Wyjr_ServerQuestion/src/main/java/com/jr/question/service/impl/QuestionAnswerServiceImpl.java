package com.jr.question.service.impl;

import com.alibaba.fastjson.JSON;
import com.jr.common.exception.QuestionException;
import com.jr.common.util.JedisUtil;
import com.jr.common.vo.R;
import com.jr.question.dao.QuestionAnswerDao;
import com.jr.question.dao.QuestionDao;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.entity.QuestionVo;
import com.jr.question.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    @Autowired
    private QuestionAnswerDao qaDao;
    @Autowired
    private QuestionDao qDao;

    /**
     * 通过qid查询问题详情
     * @param qid
     * @return
     * @throws QuestionException
     */
    @Override
    @Transactional(rollbackFor = QuestionException.class)
    public R selectQuestion(Long qid) throws QuestionException {
        try {
            Map<String, String> hgetall  = null;
            JedisUtil jedisUtil = JedisUtil.getInstance();
            hgetall = jedisUtil.hgetall("Qvo");
            String qvos = hgetall.get(qid.toString());
            //到redis中查询相关问题详情
            if(qvos != null && qvos.length() > 0){

                //获取该问题的在redis中浏览数
                String qbrowse = jedisUtil.hget("Qbrowse", qid.toString());
                Long number = null;
                if(qbrowse != null){
                    //有则加1L
                    number = Long.parseLong(qbrowse) + 1L;
                }else{
                    //无则初始化1L
                    number = 1L;
                }
                //把新的浏览值存到redis中
                jedisUtil.hset("Qbrowse",qid.toString(),number.toString());
                return R.setOK("Ok",qvos);

            }else{
                //从数据库把数据查出，然后存到redis中
                QuestionVo qvo = qDao.findByQid(qid);
                Object jqvo = JSON.toJSON(qvo);
                jedisUtil.hset("Qvo",""+qid,jqvo.toString());
                return R.setOK("Ok",jqvo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new QuestionException("问题详情查询异常");
        }
    }

    /**
     * 通过qid查询问题相关回复，默认返回500条数据
     * @param qid
     * @return
     * @throws QuestionException
     */
    @Override
    @Transactional(rollbackFor = QuestionException.class)
    public R selectQuestionAnswer(Long qid) throws QuestionException {
        try {
            Map<String, String> hgetall  = null;
            hgetall = null;
            JedisUtil jedisUtil = JedisUtil.getInstance();
            hgetall = jedisUtil.hgetall("QAnsw" + qid);
            //到redis中查询相关问题回复
            if(hgetall != null && hgetall.size() > 0){
                return R.setOK("Ok",hgetall);

            }else{
                //从数据库把数据查出，然后存到redis中

                List<QuestionAnswerVo> answerByQid = qaDao.findAnswerByQid(qid);
                for (QuestionAnswerVo qavo:
                        answerByQid) {
                    Object jqavo = JSON.toJSON(qavo);
                    hgetall.put(""+qavo.getId(),qavo.toString());
                }
                jedisUtil.hmset("QAmsw" + qid,hgetall);
            }
            return R.setOK("Ok",hgetall);
        } catch (Exception e) {
            e.printStackTrace();
            throw new QuestionException("问题详情查询异常");
        }
    }
}
