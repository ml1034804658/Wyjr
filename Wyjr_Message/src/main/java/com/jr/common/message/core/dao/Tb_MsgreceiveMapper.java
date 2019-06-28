package com.jr.common.message.core.dao;

import com.jr.common.message.core.entity.Tb_Msgreceive;

import java.util.List;

public interface Tb_MsgreceiveMapper {


    int insert(Tb_Msgreceive record);

    List<Tb_Msgreceive> selectAll();


}