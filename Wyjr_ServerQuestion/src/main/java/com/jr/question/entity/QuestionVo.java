package com.jr.question.entity;

import com.jr.entity.Tb_Question;
import lombok.Data;

@Data
public class QuestionVo extends Tb_Question {
    private String nickname;
    private String headurl;
    private Long answerNum;
    private String qq;
}
