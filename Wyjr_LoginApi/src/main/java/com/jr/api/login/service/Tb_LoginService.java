package com.jr.api.login.service;

import com.jr.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author feri
 *@Date Created in 2019/6/14 16:23
 */
@FeignClient(name = "LoginProvider")
public interface Tb_LoginService {
    //登录
    @PostMapping("/login/login.do")
    R login(@RequestParam("phone") String phone, @RequestParam("password") String password);
    //检查是否有效
    @GetMapping("/login/checklogin.do")
    R check(@RequestParam("token") String token);
    //注销
    @GetMapping("/login/exit.do")
    R exit(@RequestParam("token") String token);
}
