package com.qianfeng.wyjr.server.findone.service.impl;

import com.jr.common.config.ProjectConfig;
import com.jr.common.exception.FindOneException;
import com.jr.common.util.JedisUtil;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.qianfeng.wyjr.server.findone.dao.Tb_FindothersMapper;
import com.qianfeng.wyjr.server.findone.dao.Tb_Findothers_CommentMapper;
import com.qianfeng.wyjr.server.findone.service.FindOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindOtherServiceImpl implements FindOtherService {

    @Autowired private Tb_FindothersMapper tb_findothersMapper;


    @Autowired private Tb_Findothers_CommentMapper tb_findothers_commentMapper;

    //最新捡人
    @Override
    public R selectAll() {
        List<Tb_Findothers> list_tb_findothers = tb_findothersMapper.selectAll();

        return R.setOK("OK", list_tb_findothers);
    }

    //最热捡人
    public R selectAllByHot() {
        List<Tb_Findothers> list_tb_findothers = tb_findothersMapper.selectAllByHot();
        return R.setOK("OK", list_tb_findothers);
    }



    @Override
    public R selectByPrimaryKey(Long jid) {
        Tb_Findothers tb_findothers = tb_findothersMapper.selectByPrimaryKey(jid);
        return R.setOK("OK",tb_findothers);
    }

    @Override
    public R savemsg(Tb_Findothers findothers) throws FindOneException{
        try {
            tb_findothersMapper.insert(findothers);
            return R.setOK();
        } catch (Exception e) {
            throw  new FindOneException("插入失败");
        }
    }

    @Override
    @Transactional(rollbackFor = {FindOneException.class})
    public R selectDetailByJid(Long jid) throws FindOneException {
        // 查找检人的信息
        try {
            Tb_Findothers tb_findothers = tb_findothersMapper.selectByPrimaryKey(jid);
            tb_findothers_commentMapper.selectByJid(jid);
            // 判断redis中是否有该条信息的浏览量
            String pageview = ProjectConfig.PAGEVIEW+jid;
            if(JedisUtil.getInstance().exists(pageview)){
                // redis中存在该检人信息的浏览量
                String spageview = JedisUtil.getInstance().get(pageview);
                int pv = Integer.parseInt(spageview);
                pv ++ ;
            }else {
                // redis中存在
            }
        } catch (Exception e) {
            throw  new FindOneException("啊哦~网络崩溃了");
        }
        return null;
    }


}
