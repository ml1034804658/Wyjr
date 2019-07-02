package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Findothers_Comment {
    private Long id;

    private Long jid;       //捡人信id

    private Long uid;        //用户id

    private Long parentid;    //一级id

    private Long rid;         //回复的id

    private String rcontent;   //回复内容

    private Date rtime;       //回复时间


}