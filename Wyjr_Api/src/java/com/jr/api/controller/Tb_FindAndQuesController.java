package com.jr.api.controller;

import com.jr.api.service.Tb_FindAndQuesService;
import com.jr.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value ="用户", tags = "用户")
@RestController
public class Tb_FindAndQuesController {

    @Autowired
    private Tb_FindAndQuesService tb_findAndQuesService;

    @CrossOrigin
    @ApiOperation(value = "我的收藏",notes = "用户的收藏")
    @GetMapping("/api/findAndQues/findAll.do")
    public R findFindAndQues(){
        return tb_findAndQuesService.findFindAndQues();
    }
}
