package com.jr.server.goods.service;

import com.jr.common.vo.R;

public interface GoodsService {
    public R findAllGoods();
    public R buyGoods(int uid, int gid);
}
