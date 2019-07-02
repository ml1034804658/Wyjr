package com.jr.question.service.impl;

import com.jr.common.util.JedisUtil;
import com.jr.question.dao.QuestionWithEssenceDao;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.service.QuestionWithEssenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class QuestionWithEssenceServiceImpl implements QuestionWithEssenceService {

    @Autowired
    private QuestionWithEssenceDao questionWithEssenceDao;


    @Override
    public List<QuestionAnswerVo> findAllEssence() {

       /* //连接Redis服务
        Jedis jedis = new Jedis("39.105.189.141");
        System.out.println("连接成功");
        //获取数据并输出
        Set<String> keys=jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key=it.next();
            System.out.println(key);
        }*/

        return questionWithEssenceDao.findAllWithEssence();
    }
}
