package com.jr.question.api.controller;

import com.jr.entity.Tb_Question;
import com.jr.question.api.service.QuestionWithEssenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionWithEssenceController {

    @Autowired
    private QuestionWithEssenceService questionWithEssenceService;

    @GetMapping("/api/question/essence.do")
    public List<Tb_Question> findAllWithEssence(){

        return questionWithEssenceService.findAllWithEssence();
    }

}
