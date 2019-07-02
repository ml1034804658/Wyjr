package com.jr.question.controller;

import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.service.QuestionWithNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class QuestionWithNewController {

    @Autowired
    private QuestionWithNewService questionWithNewService;

    @GetMapping("/question/new.do")
    public List<QuestionAnswerVo> findAllNewest(){

        return questionWithNewService.findAllNewest();
    }

}
