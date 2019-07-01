package com.jr.question.dao;

import com.jr.question.entity.QuestionAnswerVo;

import java.util.List;

public interface QuestionAnswerDao {

    /**
     * 通过问题id查询到对应的问题回复
     * @param qid
     * @return
     */
    public List<QuestionAnswerVo> findAnswerByQid(Long qid);


}
