package com.qianfeng.wyjr.server.findone.service.impl;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers_Comment;
import com.qianfeng.wyjr.server.findone.dao.Tb_Findothers_CommentMapper;
import com.qianfeng.wyjr.server.findone.service.FindOtherCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindOtherCommentServiceImpl implements FindOtherCommentService {
    @Autowired
    private Tb_Findothers_CommentMapper tb_findothers_commentMapper;

    @Override
    public R selectByPrimaryKey(Long id) {
        Tb_Findothers_Comment tb_findothers_comment = tb_findothers_commentMapper.selectByPrimaryKey(id);
        return R.setOK("OK", tb_findothers_comment);
    }

}
