package com.jr.server.goods.service.impl;


import com.jr.common.exception.QuestionException;
import com.jr.common.util.TimeUtil;
import com.jr.common.vo.R;
import com.jr.entity.Tb_User_Score;
import com.jr.entity.Tb_User_Scorechange;
import com.jr.server.goods.dao.GoodsDao;
import com.jr.server.goods.dao.Tb_User_ScoreMapper;
import com.jr.server.goods.dao.Tb_User_ScorechangeMapper;
import com.jr.server.goods.service.GoodsService;
import com.jr.server.goods.vo.GoodsBuyLog;
import com.jr.server.goods.vo.VGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired(required = false)
    private GoodsDao goodsDao;

    @Autowired(required = false)
    private Tb_User_ScoreMapper scoreDao;

    @Autowired(required = false)
    private Tb_User_ScorechangeMapper scoreChangeDao;
    @Override
    public R findAllGoods() {
        return R.setOK("OK", goodsDao.selectAll());
    }

    @Override
    @Transactional(rollbackFor = QuestionException.class)
    public R buyGoods(int uid, int gid) {
        Tb_User_Score score = scoreDao.selectByUid(uid);
        if (score == null){
            return R.setERROR("用户不存在");
        }
        VGoods goods = goodsDao.selectByGid(gid);
        if (goods == null){
            return R.setERROR("该商品不存在");
        }
        int currentscore = score.getCurrscore();

        int integral = goods.getIntegral();
        if (currentscore < integral){
            GoodsBuyLog goodsBuyLog = new GoodsBuyLog();
            goodsBuyLog.setStatus(2);
            goodsBuyLog.setGoodsId(gid);
            goodsBuyLog.setCtime(new Date());
            goodsDao.addLog(goodsBuyLog);

            return R.setERROR("积分不足");
        }else{
            currentscore = currentscore - integral;
            score.setCurrscore(currentscore);
            scoreDao.insert(score);

            Tb_User_Scorechange scorechange = new Tb_User_Scorechange();
            scorechange.setUid((long)uid);
            scorechange.setStartdate(new Date());
            scorechange.setEnddate(TimeUtil.getMonths(1));
            scorechange.setInfo("购买商品，使用积分" + integral);
            scorechange.setScore(integral);
            scorechange.setFlag(1);
            scoreChangeDao.insert(scorechange);

            GoodsBuyLog goodsBuyLog = new GoodsBuyLog();
            goodsBuyLog.setStatus(1);
            goodsBuyLog.setGoodsId(gid);
            goodsBuyLog.setCtime(new Date());
            goodsDao.addLog(goodsBuyLog);

            return R.setOK("购买成功", null);

        }

    }
}
