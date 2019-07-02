package com.jr.server.user.dao;

import com.jr.entity.Tb_Collection;

import java.util.List;

public interface Tb_CollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tb_Collection record);

    int insertSelective(Tb_Collection record);

    Tb_Collection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tb_Collection record);

    int updateByPrimaryKey(Tb_Collection record);

    public List<Tb_Collection> findAll(long uid);
}