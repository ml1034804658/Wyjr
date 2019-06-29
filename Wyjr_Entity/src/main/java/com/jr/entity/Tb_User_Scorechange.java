package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_User_Scorechange {
    private Integer id;

    private Long uid;

    private Integer score;

    private String info;

    private Date startdate;

    private Date enddate;

    private Integer flag;


}