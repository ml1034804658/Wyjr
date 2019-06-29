package com.qianfeng.wyjr.server.findone.dao;

import com.jr.entity.Tb_Findothers;

import java.util.List;

public interface Tb_FindothersMapper {
    int deleteByPrimaryKey(Long jid);

    int insert(Tb_Findothers record);

    int insertSelective(Tb_Findothers record);

    List<Tb_Findothers> selectAll();

    List<Tb_Findothers> selectAllByHot();

    Tb_Findothers selectByPrimaryKey(Long jid);

    int updateByPrimaryKeySelective(Tb_Findothers record);

    int updateByPrimaryKey(Tb_Findothers record);
    // 跟新检人信息的浏览量
    int updatePageView(long jid, long pageview);
}