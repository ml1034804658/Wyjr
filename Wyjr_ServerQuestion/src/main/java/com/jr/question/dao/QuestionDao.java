package com.jr.question.dao;

import com.jr.entity.Tb_Question;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.entity.QuestionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionDao {

   /*
   * 展示最新
   * */
   public List<QuestionAnswerVo> findAll();

   /**
    * 添加操作
    * @return
    */
   public Integer add(Tb_Question question);

   /**
    * 通过问题id查询到问题详情
    * @param qid
    * @return
    */
   public QuestionVo findByQid(@Param("qid") Long qid);

}
