package com.jr.server.user.dao;

import com.jr.entity.Tb_User;

import java.util.List;

public interface Tb_UserMapper {


    int insert(Tb_User record);

    List<Tb_User> all();

    Tb_User selectByPhone(String phone);
}