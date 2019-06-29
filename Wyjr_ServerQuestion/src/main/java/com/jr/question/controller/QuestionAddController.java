package com.jr.question.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question;
import com.jr.question.exception.QuestionException;
import com.jr.question.service.QuestionAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionAddController {
    @Autowired
    private QuestionAddService qas;

    @PostMapping("/question/add.do")
    public R saveQuestion(@RequestBody Tb_Question question){
        R r = null;
        try {
             r = qas.AddQuestion(question);
            return r;
        } catch (QuestionException e) {
            e.printStackTrace();
        }

        return r;
    }
}
