package com.jr.question.dao;

import com.jr.entity.Tb_Question;

import java.util.List;

public interface QuestionWithNewDao {

    public List<Tb_Question> findAllWithNew();

}
