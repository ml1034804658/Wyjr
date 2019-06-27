package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Question {
    private Long qid;

    private Long uid;         //用户id

    private String content;    //内容

    private Date cretetime;      //创建时间

    private String imageurl;     //图片路径

    private Integer state;      //采纳状态  1.被采纳 0.没被采纳

    private Integer reward;     //赏金


}