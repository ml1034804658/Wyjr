package com.qianfeng.wyjr.server.findone.service;

import com.jr.common.exception.FindOneException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers;

public interface FindOtherService {

    R selectAll();
    R selectAllByHot();

    R selectByPrimaryKey(Long jid);



    R savemsg(Tb_Findothers findothers) throws FindOneException;
    // 根据检人信息的id查找相关详细的信息和评论
    R selectDetailByJid(Long jid) throws  FindOneException;

    void updatePageView(long jid, int pageview);
}
