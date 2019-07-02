package com.jr.question.controller;

import com.jr.entity.Tb_Question;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.service.QuestionWithEssenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionWithEssenceController {

    @Autowired
    private QuestionWithEssenceService questionWithEssenceService;

    @GetMapping("question/essence.do")
    public List<QuestionAnswerVo> findAllWithEssence(){

        return questionWithEssenceService.findAllEssence();
    }

}
