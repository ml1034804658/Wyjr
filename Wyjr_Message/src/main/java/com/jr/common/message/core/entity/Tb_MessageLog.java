package com.jr.common.message.core.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_MessageLog {
    private Long id;

    private Long mid;

    private Date createtime;

    private String ip;

    private String info;


}