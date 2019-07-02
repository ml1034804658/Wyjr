package com.jr.server.user.controller;

import com.jr.common.vo.R;
import com.jr.server.user.service.Tb_FindAndQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tb_FindAndQuesController {

    @Autowired
    private Tb_FindAndQuesService tb_findAndQuesService;

    @GetMapping("findAndQues/findAll.do")
    public R findFindAndQues(){
        return tb_findAndQuesService.findFindAndQues();
    }
}
