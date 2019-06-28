package com.jr.server.user.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.exception.UserException;
import com.jr.common.util.TimeUtil;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import com.jr.entity.Tb_User_Score;
import com.jr.entity.Tb_User_Scorechange;
import com.jr.server.user.dao.Tb_UserMapper;
import com.jr.server.user.dao.Tb_User_InfoMapper;
import com.jr.server.user.dao.Tb_User_ScoreMapper;
import com.jr.server.user.dao.Tb_User_ScorechangeMapper;
import com.jr.server.user.service.Tb_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class Tb_UserServiceImpl implements Tb_UserService {
    @Autowired
    private Tb_UserMapper userMapper;
    @Autowired
    private Tb_User_InfoMapper userInfoMapper;
    @Autowired
    private Tb_User_ScoreMapper userScoreMapper;
    @Autowired
    private Tb_User_ScorechangeMapper userScorechangeMapper;


    @Override
    @Transactional(rollbackFor = {UserException.class})
    public R save(Tb_User user) throws UserException {
        try {
            //新增用户
            userMapper.insert(user);
            //初始化用户详情
            userInfoMapper.insertInit(user.getId());
            //初始化积分
            Tb_User_Scorechange scorechange = new Tb_User_Scorechange();
            scorechange.setUid(user.getId());
            scorechange.setScore(ProjectConfig.INITNEWSCORE);
            scorechange.setInfo("新用户，奖励"+ProjectConfig.INITNEWSCORE+"积分");
            scorechange.setStartdate(new Date());
            scorechange.setEnddate(TimeUtil.getDays(ProjectConfig.INITNEWSEXPIRE));
            userScorechangeMapper.insert(scorechange);
            //注册送积分
            Tb_User_Score userScore = new Tb_User_Score();
            userScore.setUid(user.getId());
            userScore.setTotalscore(ProjectConfig.INITNEWSCORE);
            userScore.setCurrscore(ProjectConfig.INITNEWSCORE);
            userScoreMapper.insert(userScore);
        }catch (Exception e){
            throw new UserException("用户注册异常："+e.getMessage());
        }

        return R.setOK();
    }

    @Override
    public R all() {
        return R.setOK("OK",userMapper.all());
    }
}
