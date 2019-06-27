package com.qianfeng.wyjr.server.findone.dao;

import com.jr.entity.Tb_Findothers;

public interface Tb_FindothersMapper {
    int deleteByPrimaryKey(Long jid);

    int insert(Tb_Findothers record);

    int insertSelective(Tb_Findothers record);

    Tb_Findothers selectByPrimaryKey(Long jid);

    int updateByPrimaryKeySelective(Tb_Findothers record);

    int updateByPrimaryKey(Tb_Findothers record);
}