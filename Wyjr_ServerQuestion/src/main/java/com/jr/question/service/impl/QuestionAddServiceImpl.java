package com.jr.question.service.impl;

import com.jr.common.config.ProjectConfig;
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
            Integer  add = qDao.add(question);

            Tb_User_Scorechange scorechange = new Tb_User_Scorechange();
            scorechange.setUid(question.getUid());
            Integer reward = question.getReward();
            scorechange.setScore(reward);
            scorechange.setInfo("发布悬赏问题，扣除"+reward+"积分");
            scorechange.setFlag(ProjectConfig.AdoptState);
            scDao.add(scorechange);
            userScoreDao.updata(question.getUid(),question.getReward());


        } catch (Exception e) {
            throw new QuestionException("悬赏添加异常");
        }

        return R.setOK();
    }


}
