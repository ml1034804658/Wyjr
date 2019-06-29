package com.jr.question.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.util.TimeUtil;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Question;
import com.jr.entity.Tb_User_Scorechange;
import com.jr.question.dao.QuestionDao;
import com.jr.question.dao.ScorechangeDao;
import com.jr.question.dao.UserScoreDao;
import com.jr.question.exception.QuestionException;
import com.jr.question.service.QuestionAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

@Service
@Transactional(rollbackFor = QuestionException.class)
public class QuestionAddServiceImpl implements QuestionAddService {

    @Autowired
    private QuestionDao qDao;
    @Autowired
    private ScorechangeDao scDao;
    @Autowired
    private UserScoreDao userScoreDao;


    @Override
    public R AddQuestion(Tb_Question question) throws QuestionException {

        try {
            //问题表
            question.setState(ProjectConfig.NoAdoptState);
            question.setCretetime(new Date());
            Integer  add = qDao.add(question);

            Integer totalscore = userScoreDao.selectTotalscore(question.getUid());
            Integer reward = question.getReward();
            if (totalscore < reward)
            {
                throw new QuestionException("用户积分不足，导致悬赏添加失败");
            }

            Tb_User_Scorechange scorechange = new Tb_User_Scorechange();
            scorechange.setUid(question.getUid());
            scorechange.setScore(reward);
            scorechange.setInfo("发布悬赏问题，扣除"+reward+"积分");
            scorechange.setFlag(ProjectConfig.NoExpire);
            scorechange.setStartdate(new Date());
            Date months = TimeUtil.getMonths(1);
            scorechange.setEnddate(months);
            scDao.add(scorechange);

            //用户积分表
            userScoreDao.update(question.getUid(),totalscore - question.getReward());


        } catch (Exception e) {
            e.printStackTrace();
            throw new QuestionException("悬赏添加异常");
        }

        return R.setOK();
    }


}
