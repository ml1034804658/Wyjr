package com.qfedu.wyjr.api.findone.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "FindOneProvider")
public interface FindOtherService {
    @GetMapping("find/ohter/findAll.do")
    R selectAll();

    @GetMapping("find/ohter/findAllHot.do")
    R selectAllByHot();



    @GetMapping("find/ohter/find.do")
    R selectByPrimaryKey(@RequestParam("jid") Long jid);

    @PostMapping("find/other/save.do")
    R save(@RequestBody Tb_Findothers findothers);
}