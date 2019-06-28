package com.jr.common.message.core.dao;

import com.jr.common.message.core.entity.Tb_Message;

import java.util.List;

public interface Tb_MessageMapper {


    int insert(Tb_Message record);

    List<Tb_Message> selectAll();
}