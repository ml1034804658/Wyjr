package com.jr.question.service;

import com.jr.entity.Tb_Question;

import java.util.List;

public interface QuestionWithNewService {

    List<Tb_Question> findAllNewest();
}
