package com.qianfeng.wyjr.server.findone.service.impl;

import com.jr.common.exception.FindOneException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;
import com.qianfeng.wyjr.server.findone.dao.Tb_FindothersMapper;
import com.qianfeng.wyjr.server.findone.service.FindOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindOtherServiceImpl implements FindOtherService {

    @Autowired private Tb_FindothersMapper tb_findothersMapper;


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


}
