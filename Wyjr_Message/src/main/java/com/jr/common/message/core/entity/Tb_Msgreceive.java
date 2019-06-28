package com.jr.common.message.core.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Msgreceive {
    private Long id;

    private String no;

    private Date createtime;

    private Integer flag;


}