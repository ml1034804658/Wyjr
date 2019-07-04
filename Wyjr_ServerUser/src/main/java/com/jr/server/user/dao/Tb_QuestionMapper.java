package com.jr.server.user.dao;

import com.jr.entity.Tb_Question;

import java.util.List;

public interface Tb_QuestionMapper {
    int deleteByPrimaryKey(Long qid);

    int insert(Tb_Question record);

    int insertSelective(Tb_Question record);

    Tb_Question selectByPrimaryKey(Long qid);

    int updateByPrimaryKeySelective(Tb_Question record);

    int updateByPrimaryKey(Tb_Question record);

    public List<Tb_Question> findByQuestionUid(long uid);

    public List<Tb_Question> findAll(long uid);
}