package com.jr.question.service.impl;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question_Answer;
import com.jr.question.dao.CommentDao;
import com.jr.question.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private CommentDao commentDao;

    @Override
    public R insertComment(Tb_Question_Answer comment) {

        commentDao.insert(comment);

        return R.setOK("评论成功",null);
    }
}
