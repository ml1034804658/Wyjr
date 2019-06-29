package com.wyjr.api.goods.service;

import com.jr.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GoodsProvider")
public interface GoodsService {
    @GetMapping("goods/list.do")
    public R goodsList();
}
