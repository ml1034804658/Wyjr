package com.jr.server.user.controller;

import com.jr.common.vo.R;
import com.jr.server.user.service.Tb_QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tb_QuestionController {

    @Autowired
    private Tb_QuestionService tb_questionService;

    @GetMapping("question/findByUid.do")
    public R findByQuestionUid(){
        return tb_questionService.findByQuestionUid();
    }

}
