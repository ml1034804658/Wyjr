package com.qfedu.wyjr.api.findone.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers_Comment;
import com.qfedu.wyjr.api.findone.service.FindOtherCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FindOtherCommentController {

    @Autowired
    private FindOtherCommentService findOtherCommentService;


    @GetMapping("/api/find/ohter/findcomment.do")
    private R find(@RequestParam("id") Long id) {
        return findOtherCommentService.selectByPrimaryKey(id);
    }

    @PostMapping("/api/find/other/commmet/save.do")
    private  R saveComment(@RequestBody Tb_Findothers_Comment comment){
        return findOtherCommentService.saveComment(comment);
    };

    @GetMapping("/api/find/other/commmet/count.do")
    R countCommentByJid(@RequestParam("jid") Long jid){
        return findOtherCommentService.countCommentByJid(jid);
    };
}