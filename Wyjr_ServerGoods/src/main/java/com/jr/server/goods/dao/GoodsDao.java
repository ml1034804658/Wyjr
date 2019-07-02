package com.jr.server.goods.dao;

import com.jr.server.goods.vo.GoodsBuyLog;
import com.jr.server.goods.vo.VGoods;

import java.util.List;

public interface GoodsDao {
    public List<VGoods> selectAll();
    public void addLog(GoodsBuyLog goodsBuyLog);
    public VGoods selectByGid(int gid);

}
