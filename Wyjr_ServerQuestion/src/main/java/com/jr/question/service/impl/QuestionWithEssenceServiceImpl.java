package com.jr.question.service.impl;

import com.alibaba.fastjson.JSON;
import com.jr.common.util.JedisUtil;
import com.jr.question.dao.QuestionWithEssenceDao;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.service.QuestionWithEssenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class QuestionWithEssenceServiceImpl implements QuestionWithEssenceService {

    @Autowired
    private QuestionWithEssenceDao questionWithEssenceDao;


    @Override
    public List<QuestionAnswerVo> findAllEssence() {

       /* Map<String,String> map = null;
        JedisUtil jedisUtil = JedisUtil.getInstance();
        map = jedisUtil.hgetall("Qwe");
        String qwes = map.get(toString());
        Object qwess = JSON.parse(qwes);

        //到Redis中查询展示详情
        if (qwes != null && qwes.length() > 0){
            //获取Redis中精华
            String browseNum = jedisUtil.hget("browseNum",toString());

        }*/




        return questionWithEssenceDao.findAllWithEssence();
    }
}
