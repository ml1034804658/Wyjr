package com.jr.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Tb_User_Log {
    private Long id;

    private Integer uid;

    private Integer flag;

    private Date createtime;

    private String content;


}