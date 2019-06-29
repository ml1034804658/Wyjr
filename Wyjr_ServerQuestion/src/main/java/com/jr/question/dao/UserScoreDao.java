package com.jr.question.dao;

import org.apache.ibatis.annotations.Param;

public interface UserScoreDao {

    public Integer updata(@Param("uid") Long uid,@Param("score") Integer score);
}
