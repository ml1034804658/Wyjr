package com.jr.question.service;

import com.jr.common.vo.R;

public interface QuestionAnswerService {

    public R selectQuestion(Long qid);

    public R sellectQuestionAnswer(Long qid);
}
