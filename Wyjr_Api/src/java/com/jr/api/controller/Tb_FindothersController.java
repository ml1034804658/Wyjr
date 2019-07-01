package com.jr.api.controller;

import com.jr.api.service.Tb_FindothersService;
import com.jr.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tb_FindothersController {

    @Autowired
    private Tb_FindothersService tb_findothersService;

    @GetMapping("/api/tbfindothers/findByUid.do")
    public R findByTbFindothers(){
        return tb_findothersService.findByTbFindothers();
    }

}
