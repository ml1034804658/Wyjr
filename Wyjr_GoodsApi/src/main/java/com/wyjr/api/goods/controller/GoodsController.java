package com.wyjr.api.goods.controller;

import com.jr.common.vo.R;
import com.wyjr.api.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired(required = false)
    private GoodsService goodsService;

    @GetMapping("goods/list.do")
    public R goodsList(){
        return goodsService.goodsList();
    }
}
