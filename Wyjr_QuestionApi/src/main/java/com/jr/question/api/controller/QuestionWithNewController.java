package com.jr.question.api.controller;

import com.jr.entity.Tb_Question;
import com.jr.question.api.service.QuestionService;
import com.jr.question.api.service.QuestionWithNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionWithNewController {

    @Autowired
    private QuestionWithNewService questionWithNewService;

    @GetMapping("/api/question/new.do")
    public List<Tb_Question> findAllNewest(){

        return questionWithNewService.findAllNewest();
    }

}
