package com.qianfeng.wyjr.server.findone.controller;

import com.jr.common.vo.R;
import com.qianfeng.wyjr.server.findone.service.FindOtherCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindOtherCommentController {

    @Autowired
    private FindOtherCommentService findOtherCommentService;


    @GetMapping("find/ohter/findcomment.do")
    private R find(@RequestParam("id") Long id) {
        return findOtherCommentService.selectByPrimaryKey(id);
    }
}
