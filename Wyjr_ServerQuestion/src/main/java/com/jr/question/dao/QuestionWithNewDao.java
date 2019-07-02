package com.jr.question.dao;

import com.jr.entity.Tb_Question;
import com.jr.question.entity.QuestionAnswerVo;

import java.util.List;

public interface QuestionWithNewDao {

    public List<QuestionAnswerVo> findAllWithNew();

}
