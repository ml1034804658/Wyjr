package com.jr.server.user.dao;

import com.jr.entity.Tb_User_Info;

public interface Tb_User_InfoMapper {


    int insert(Tb_User_Info record);

    int insertInit(Long uid);


}