package com.jr.server.goods.service.impl;


import com.jr.common.vo.R;
import com.jr.server.goods.dao.GoodsDao;
import com.jr.server.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired(required = false)
    private GoodsDao goodsDao;
    @Override
    public R findAllGoods() {
        return R.setOK("OK", goodsDao.selectAll());
    }
}
