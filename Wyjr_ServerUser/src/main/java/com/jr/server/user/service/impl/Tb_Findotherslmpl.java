package com.jr.server.user.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.jr.entity.Tb_User;
import com.jr.server.user.dao.Tb_FindothersMapper;
import com.jr.server.user.dao.Tb_UserMapper;
import com.jr.server.user.service.Tb_FindothersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class Tb_Findotherslmpl implements Tb_FindothersService {

    @Autowired
    private Tb_FindothersMapper tb_findothersMapper;

    @Autowired
    private Tb_UserMapper tb_userMapper;

    @Override
    @Transactional
    public R findByUid() {
        Jedis jedis = new Jedis(ProjectConfig.REDISHOST, ProjectConfig.REDISPORT);
        jedis.auth(ProjectConfig.REDISPASS);
        String phone = jedis.get("uc");
        Tb_User tb_user = tb_userMapper.selectByPhone(phone);
        return R.setOK("OK",tb_findothersMapper.findByTb_Findothers(tb_user.getId()));
    }
}
