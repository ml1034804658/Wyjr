package com.jr.question.controller;

import com.jr.common.exception.QuestionException;
import com.jr.common.vo.R;
import com.jr.question.service.QuestionAnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionDetailController  {
    private QuestionAnswerService qas;

    @GetMapping("/question/selectQDetail.do")
    public R getQuestionDetail(@RequestParam Long qid){
        R r = null;
        try {
             r = qas.selectQuestion(qid);
        } catch (QuestionException e) {
            e.printStackTrace();
            r = R.setERROR(e.getMessage());
        }
        return r;
    }
    @GetMapping("/question/selectQAnswer.do")
    public R getQuestionAnswer(@RequestParam Long qid){
        R r = null;
        try {
            r = qas.selectQuestionAnswer(qid);
        } catch (QuestionException e) {
            e.printStackTrace();
            r = R.setERROR(e.getMessage());
        }
        return r;
    }
}
