package com.qianfeng.wyjr.server.findone.dao;


import com.jr.entity.Tb_Findothers_Comment;

public interface Tb_Findothers_CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tb_Findothers_Comment record);

    int insertSelective(Tb_Findothers_Comment record);

    Tb_Findothers_Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tb_Findothers_Comment record);

    int updateByPrimaryKey(Tb_Findothers_Comment record);
}