package com.jr.question.dao;

import org.apache.ibatis.annotations.Param;

public interface UserScoreDao {
    public Integer selectTotalscore(Long uid);

    public Integer update(@Param("uid") Long uid,@Param("score") Integer score);
}
