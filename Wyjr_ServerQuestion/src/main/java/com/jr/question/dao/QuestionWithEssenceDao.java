package com.jr.question.dao;

import com.jr.question.entity.QuestionAnswerVo;

import java.util.List;

public interface QuestionWithEssenceDao {

    public List<QuestionAnswerVo> findAllWithEssence();
}
