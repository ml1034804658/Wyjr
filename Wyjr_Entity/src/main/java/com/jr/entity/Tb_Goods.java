package com.jr.entity;

import lombok.Data;

@Data
public class Tb_Goods {
    private Long id;

    private String goodsname;

    private String goodsimage;

    private Integer price;

    private String content;


}