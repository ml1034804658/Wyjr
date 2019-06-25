package com.jr.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Tb_User_Info {
    private Integer id;

    private Integer uid;

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