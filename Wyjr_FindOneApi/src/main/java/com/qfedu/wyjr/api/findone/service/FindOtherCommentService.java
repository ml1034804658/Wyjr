package com.qfedu.wyjr.api.findone.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers_Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "FindOneProvider")
public interface FindOtherCommentService {

    @GetMapping("find/ohter/findcomment.do")
    R selectByPrimaryKey(@RequestParam("jid") Long id);

    @PostMapping("find/other/commmet/save.do")
   R saveComment(@RequestBody Tb_Findothers_Comment comment);

    @GetMapping("find/other/commmet/count.do")
    R countCommentByJid(@RequestParam("jid") Long jid);

}