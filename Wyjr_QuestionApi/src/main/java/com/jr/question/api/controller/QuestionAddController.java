package com.jr.question.api.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question;
import com.jr.question.api.service.QuestionAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionAddController {
    @Autowired
    private QuestionAddService qas;
    @PostMapping("/api/question/save.do")
    public R save(Tb_Question question){
        R r = qas.saveQuestion(question);
        return r;
    }
}
