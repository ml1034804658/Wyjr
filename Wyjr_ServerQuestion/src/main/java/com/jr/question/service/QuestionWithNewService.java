package com.jr.question.service;

import com.jr.question.entity.QuestionAnswerVo;

import java.util.List;

public interface QuestionWithNewService {

    List<QuestionAnswerVo> findAllNewest();
}
