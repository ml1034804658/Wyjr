package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Findothers {
    private Long jid;

    private Long uid;

    private String route;

    private String content;

    private Date createtime;

    private Integer pageview;

    private String imageurl;


}