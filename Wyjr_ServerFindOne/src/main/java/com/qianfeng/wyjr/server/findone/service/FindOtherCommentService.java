package com.qianfeng.wyjr.server.findone.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Findothers_Comment;

public interface FindOtherCommentService {
    // 发布评论
    R insertComment(Tb_Findothers_Comment comment);

    R countCommentByJid(Long jid);
}
