package com.jr.question.service;

import com.jr.common.exception.QuestionException;
import com.jr.common.vo.R;

public interface QuestionAnswerService {

    public R selectQuestion(Long qid) throws QuestionException;

    public R selectQuestionAnswer(Long qid) throws QuestionException;
}
