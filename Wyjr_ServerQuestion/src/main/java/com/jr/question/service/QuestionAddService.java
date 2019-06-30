package com.jr.question.service;

import com.jr.common.exception.QuestionException;
import com.jr.common.vo.R;
import com.jr.entity.Tb_Question;

public interface QuestionAddService {
    /**
     * 用户添加悬赏
     * @param question
     * @return
     */
    public R AddQuestion(Tb_Question question) throws QuestionException;
}
