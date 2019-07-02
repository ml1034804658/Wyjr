package com.qianfeng.wyjr.server.findone.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers_Comment;
import com.qianfeng.wyjr.server.findone.service.FindOtherCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FindOtherCommentController {

    @Autowired
    private FindOtherCommentService findOtherCommentService;

    @PostMapping("find/other/commmet/save.do")
    private R saveComment(@RequestBody Tb_Findothers_Comment comment){
        return findOtherCommentService.insertComment(comment);
    }

    @GetMapping("find/other/commmet/count.do")
   private R countCommentByJid(@RequestParam ("jid") Long jid){
        return findOtherCommentService.countCommentByJid(jid);
    };
}
