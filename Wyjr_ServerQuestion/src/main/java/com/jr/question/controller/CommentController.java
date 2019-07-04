package com.jr.question.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question_Answer;
import com.jr.question.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("wd/comment.do")
    public R saveComment(@RequestBody Tb_Question_Answer comment){
        return commentService.insertComment(comment);
    }
}
