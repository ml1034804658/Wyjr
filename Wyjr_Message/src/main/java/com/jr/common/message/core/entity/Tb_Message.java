package com.jr.common.message.core.entity;

import lombok.Data;

@Data
public class Tb_Message {
    private Long id;

    private Integer pcode;

    private Integer type;

    private String title;

    private String content;

    private String receive;

    private Integer flag;




}