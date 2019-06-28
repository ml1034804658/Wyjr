package com.jr.server.user.controller;

import com.jr.common.exception.UserException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import com.jr.server.user.service.Tb_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Tb_UserController {
    @Autowired
    private Tb_UserService userService;

    //查询
    @GetMapping("user/all.do")
    public R all(){
        return userService.all();
    }
    //新增
    @PostMapping("user/save.do")
    public R save(@RequestBody Tb_User user) throws UserException {
        return userService.save(user);
    }
}
