package com.jr.server.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface Tb_UserLogDao {
    @Insert("insert into tb_user_log(uid,flag,content,createtime) values(#{uid},2,#{content},now())")
    int save(@Param("uid") Long uid, @Param("content") String content);
}
