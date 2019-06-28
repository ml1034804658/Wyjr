package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Question_Answer {
    private Long id;

    private Long qid;             //问答id

    private Long uid;           //用户id

    private Long parentId;       //一级id

    private Long rid;            //回复的id

    private String rContent;    //回复内容

    private Date rTime;          //回复时间




}