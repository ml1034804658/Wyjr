package com.jr.question.dao;

import com.jr.entity.Tb_Question;

import java.util.List;

public interface QuestionDao {

   public List<Tb_Question> findAll();

   /**
    * 添加操作
    * @return
    */
   public Integer add(Tb_Question question);

}
