package com.jr.question.service.impl;

import com.jr.common.vo.R;
import com.jr.question.dao.QuestionAnswerDao;
import com.jr.question.service.QuestionAnswerService;
import org.springframework.stereotype.Service;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    private QuestionAnswerDao qaDao;

    @Override
    public R selectQuestion(Long qid) {
        return null;
    }

    @Override
    public R sellectQuestionAnswer(Long qid) {
        return null;
    }
}
