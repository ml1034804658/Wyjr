package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Question_Answer {
    private Long id;

    private Long qid;

    private Long uid;

    private Long parentId;

    private Long rid;

    private String rContent;

    private Date rTime;


}