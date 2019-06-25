package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Question {
    private Long qid;

    private Long uid;

    private String content;

    private Date cretetime;

    private String imageurl;

    private Integer state;

    private Integer reward;


}