package com.jr.question.api.controller;

import com.jr.common.vo.R;
import com.jr.question.api.service.QuestionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionDetailController {
    @Autowired
    private QuestionDetailService qds;

    @GetMapping("/api/question/selectQDetail.do")
    public R getQuestionDetail(@RequestParam Long qid){
        return qds.getQuestionDetail(qid);
    }

    @GetMapping("/api/question/selectQAnswer.do")
    public R getQuestionAnswer(@RequestParam Long qid){
        return qds.getQuestionAnswer(qid);
    }
}
