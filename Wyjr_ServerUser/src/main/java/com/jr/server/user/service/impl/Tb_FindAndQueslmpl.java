package com.jr.server.user.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Collection;
import com.jr.entity.Tb_Findothers;
import com.jr.entity.Tb_Question;
import com.jr.entity.Tb_User;
import com.jr.server.user.dao.Tb_CollectionMapper;
import com.jr.server.user.dao.Tb_FindothersMapper;
import com.jr.server.user.dao.Tb_QuestionMapper;
import com.jr.server.user.dao.Tb_UserMapper;
import com.jr.server.user.service.Tb_FindAndQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class Tb_FindAndQueslmpl implements Tb_FindAndQuesService {

    @Autowired
    private Tb_FindothersMapper tb_findothersMapper;
    @Autowired
    private Tb_QuestionMapper tb_questionMapper;
    @Autowired
    private Tb_UserMapper tb_userMapper;
    @Autowired
    private Tb_CollectionMapper tb_collectionMapper;

    @Override
    @Transactional
    public R findFindAndQues() {
        Jedis jedis = new Jedis(ProjectConfig.REDISHOST, ProjectConfig.REDISPORT);
        jedis.auth(ProjectConfig.REDISPASS);
        String phone = jedis.get("uc");
        Tb_User user = tb_userMapper.selectByPhone(phone);
        List<Tb_Collection> collectionList = tb_collectionMapper.findAll(user.getId());
        for (Tb_Collection collecton: collectionList) {
            if (collecton.getState()== 1){
                List<Tb_Findothers> findothersAll = tb_findothersMapper.findAll(user.getId());
                return R.setOK("OK",findothersAll);
            }else if (collecton.getState()== 2){
                List<Tb_Question> questionsAll = tb_questionMapper.findAll(user.getId());
                return R.setOK("Ok",questionsAll);
            }
        }
        return null;
    }

}
