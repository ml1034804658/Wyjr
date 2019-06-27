package com.qianfeng.wyjr.server.findone.controller;

import com.jr.common.vo.R;
import com.qianfeng.wyjr.server.findone.dao.Tb_FindothersMapper;
import com.qianfeng.wyjr.server.findone.service.FindOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindOtherController {

    @Autowired
    private FindOtherService findOtherService;

    @GetMapping("find/ohter/find.do")
    private R find(@RequestParam("jid") Long jid) {
         return findOtherService.selectByPrimaryKey(jid);
    }
}
