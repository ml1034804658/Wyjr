package com.jr.server.user.controller;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.jr.server.user.service.Tb_FindothersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Tb_FindothersController {

    @Autowired
    private Tb_FindothersService tb_findothersService;

    @GetMapping("tbfindothers/findByUid.do")
    public R findByTbFindothers(){

        return tb_findothersService.findByUid();
    }
}
