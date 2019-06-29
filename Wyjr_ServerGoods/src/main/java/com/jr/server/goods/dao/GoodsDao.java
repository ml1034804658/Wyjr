package com.jr.server.goods.dao;

import com.jr.server.goods.vo.VGoods;

import java.util.List;

public interface GoodsDao {
    public List<VGoods> selectAll();
}
