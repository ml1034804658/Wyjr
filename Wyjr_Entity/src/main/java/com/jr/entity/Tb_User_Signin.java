package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_User_Signin {
    private Long id;

    private Long uid;

    private Integer score;

    private Integer extrascore;

    private Date createtime;


}