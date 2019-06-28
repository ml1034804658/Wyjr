package com.jr.question.controller;

import com.jr.question.service.QuestionWithNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionWithNewController {

    @Autowired
    private QuestionWithNewService questionWithNewService;


}
