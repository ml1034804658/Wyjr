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
    private Tb_Findothers_CommentMapper findothersComment;
    @Override
    public R insertComment(Tb_Findothers_Comment comment) {
        findothersComment.insert(comment);
        return  R.setOK("评论成功",null);
    }

    @Override
    public R countCommentByJid(Long jid) {
        return R.setOK("成功查找到评论数",findothersComment.countCommentByJid(jid));
    }
}
