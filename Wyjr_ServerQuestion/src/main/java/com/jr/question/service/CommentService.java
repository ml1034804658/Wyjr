package com.jr.question.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question_Answer;

public interface CommentService {

       R insertComment(Tb_Question_Answer comment);
}
