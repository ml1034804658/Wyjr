package com.jr.common.message.core.dao;

import com.jr.common.message.core.entity.Tb_MessageLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tb_MessageLogMapper {


    int insert(Tb_MessageLog record);

    List<Tb_MessageLog> selectByPage(@Param("index") int index, @Param("count") int count);

    long selectCount();




}