package com.jr.server.model;

import lombok.Data;

@Data
public class LoginToken {
    private String id;
    private String phone;
    private Long uid;
}
