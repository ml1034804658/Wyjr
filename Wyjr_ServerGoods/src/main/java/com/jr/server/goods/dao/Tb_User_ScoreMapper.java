package com.jr.server.goods.dao;

import com.jr.entity.Tb_User_Score;

public interface Tb_User_ScoreMapper {


    Tb_User_Score selectByPrimaryKey(int id);
    int insert(Tb_User_Score record);
    Tb_User_Score selectByUid(int uid);


}