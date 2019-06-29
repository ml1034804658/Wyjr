package com.qianfeng.wyjr.server.findone.controller;

import com.jr.common.exception.FindOneException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.qianfeng.wyjr.server.findone.service.FindOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FindOtherController {

    @Autowired
    private FindOtherService findOtherService;

    //最新捡人
    @GetMapping("find/ohter/findAll.do")
    private R findAll() {
        return findOtherService.selectAll();
    }
    //最热捡人
    @GetMapping("find/ohter/findAllHot.do")
    private R findAllByHot() {

        return findOtherService.selectAllByHot();
    }

    @GetMapping("find/ohter/find.do")
    private R find(@RequestParam("jid") Long jid) {
         return findOtherService.selectByPrimaryKey(jid);
    }

    @PostMapping("find/other/save.do")
    private R save(@RequestBody Tb_Findothers findothers) throws FindOneException {
        return findOtherService.savemsg(findothers);
    }
}
