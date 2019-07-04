package com.jr.api.controller;

import com.jr.api.service.Tb_QuestionService;
import com.jr.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value ="用户", tags = "用户")
@RestController
public class Tb_QuestionController {

    @Autowired
    private Tb_QuestionService tb_questionService;

    @CrossOrigin
    @ApiOperation(value = "我的提问",notes = "用户提问的信息")
    @GetMapping("/api/question/findByUid.do")
    public R findByQuestionUid(){
        return tb_questionService.findByQuestionUid();
    }
}
