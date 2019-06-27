package com.qfedu.wyjr.api.findone.controller;

import com.jr.common.vo.R;
import com.qfedu.wyjr.api.findone.service.FindOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindOtherController {

    @Autowired
    private FindOtherService findOtherService;

    @GetMapping("/api/find/ohter/find.do")
    private R find(@RequestParam("jid") Long jid) {
        return findOtherService.selectByPrimaryKey(jid);
    }
}