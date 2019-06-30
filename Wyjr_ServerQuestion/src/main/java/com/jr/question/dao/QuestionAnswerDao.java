package com.jr.question.dao;

import com.jr.question.entity.QuestionVo;

public interface QuestionAnswerDao {

    public QuestionVo findByQid(Long qid);


}
