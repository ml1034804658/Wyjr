package com.jr.question.controller;

import com.jr.entity.Tb_Question;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question.do")
    public List<QuestionAnswerVo> findAllQuestion(){

        return questionService.findAllquestion();
    }

}
