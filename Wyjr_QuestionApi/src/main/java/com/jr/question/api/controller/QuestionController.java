package com.jr.question.api.controller;

import com.jr.entity.Tb_Question;
import com.jr.question.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("question.do")
    public List<Tb_Question> findAllQuestion(){

        return questionService.findAllQuestion();
    }

}
