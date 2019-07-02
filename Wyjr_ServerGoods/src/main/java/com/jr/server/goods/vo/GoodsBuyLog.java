package com.jr.server.goods.vo;

import lombok.Data;

import java.util.Date;
@Data
public class GoodsBuyLog {
    private Integer id;
    private Integer goodsId;
    private Integer status;
    private Date ctime;
}
