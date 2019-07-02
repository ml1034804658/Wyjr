package com.wyjr.api.goods.service;

import com.jr.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GoodsProvider")
public interface GoodsService {
    @GetMapping("goods/list.do")
    public R goodsList();
    @GetMapping("goods/buy.do")
    public R goosBuy(@RequestParam("uid") int uid, @RequestParam("gid") int gid);
}
