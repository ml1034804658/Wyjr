package com.jr.server.user.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.exception.QuestionException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import com.jr.server.user.dao.Tb_QuestionMapper;
import com.jr.server.user.dao.Tb_UserMapper;
import com.jr.server.user.service.Tb_QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

@Service
public class Tb_Questionlmpl implements Tb_QuestionService {
    @Autowired
    private Tb_QuestionMapper tb_questionMapper;

    @Autowired
    private Tb_UserMapper tb_userMapper;

    @Override
    @Transactional(rollbackFor = {QuestionException.class})
    public R findByQuestionUid() {
        Jedis jedis = new Jedis(ProjectConfig.REDISHOST, ProjectConfig.REDISPORT);
        jedis.auth(ProjectConfig.REDISPASS);
        String phone = jedis.get("uc");
        Tb_User tb_user = tb_userMapper.selectByPhone(phone);
        return R.setOK("OK",tb_questionMapper.findByQuestionUid(tb_user.getId()));
    }
}
