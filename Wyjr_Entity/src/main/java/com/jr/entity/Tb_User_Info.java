package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_User_Info {
    private Long id;

    private Long uid;

    private String nickname;

    private Date birthday;

    private Integer sex;

    private String headurl;

    private Date createtime;

    private String address;

    private String email;

    private String qq;

    private Integer flag;


}