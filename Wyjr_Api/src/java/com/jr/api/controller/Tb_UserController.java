package com.jr.api.controller;

import com.jr.api.service.Tb_UserService;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Tb_UserController {
    @Autowired
    private Tb_UserService userService;

    //查询
    @GetMapping("/api/user/all.do")
    public R all(){
        return userService.all();
    }
    //新增
    @PostMapping("/api/user/save.do")
    public R save(@RequestBody Tb_User user)  {
        return userService.save(user);
    }
    @GetMapping("api/user/checkphone.do")
    public R check(@RequestParam("phone") String phone){
        return userService.check(phone);
    }


}
