package com.jr.question.entity;

import com.jr.entity.Tb_Question_Answer;
import lombok.Data;

@Data
public class QuestionAnswerVo extends Tb_Question_Answer {
    private String nickname;
    private String headurl;
    private Integer age;
}
