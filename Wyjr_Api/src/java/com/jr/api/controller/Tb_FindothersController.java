package com.jr.api.controller;

import com.jr.api.service.Tb_FindothersService;
import com.jr.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value ="用户", tags = "用户")
@RestController
public class Tb_FindothersController {

    @Autowired
    private Tb_FindothersService tb_findothersService;

    @CrossOrigin
    @ApiOperation(value = "我的捡人",notes = "用户捡人的信息")
    @GetMapping("/api/tbfindothers/findByUid.do")
    public R findByTbFindothers(){
        return tb_findothersService.findByTbFindothers();
    }

}
