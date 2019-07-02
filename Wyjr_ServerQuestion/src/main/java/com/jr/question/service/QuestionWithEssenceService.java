package com.jr.question.service;

import com.jr.entity.Tb_Question;
import com.jr.question.entity.QuestionAnswerVo;

import java.util.List;

public interface QuestionWithEssenceService {

    List<QuestionAnswerVo> findAllEssence();
}
