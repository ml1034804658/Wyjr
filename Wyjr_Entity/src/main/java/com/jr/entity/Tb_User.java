package com.jr.entity;

import lombok.Data;

@Data
public class Tb_User {
    private Long id;

    private String phone;

    private String password;

    private Integer flag;


}