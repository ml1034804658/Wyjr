package com.qfedu.wyjr.api.findone.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.qfedu.wyjr.api.findone.service.FindOtherService;
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

    @GetMapping("/api/find/ohter/find.do")
    private R find(@RequestParam("jid") Long jid) {
        return findOtherService.selectByPrimaryKey(jid);
    }

    @PostMapping("/api/find/other/save.do")
    private  R save(@RequestBody Tb_Findothers findothers){
        return findOtherService.save(findothers);
    };
}