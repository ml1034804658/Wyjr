package com.jr.server.service;


import com.jr.common.vo.R;

public interface Tb_LoginService {
    //实现登录
    R login(String phone, String pass);
    //校验登录有效性
    R checkLogin(String token);
    //注销
    R exitLogin(String token);
}
