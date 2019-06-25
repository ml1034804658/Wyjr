package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_Findothers_Comment {
    private Long id;

    private Long jid;

    private Long uid;

    private Long parentid;

    private Long rid;

    private String rContent;

    private Date rTime;


}