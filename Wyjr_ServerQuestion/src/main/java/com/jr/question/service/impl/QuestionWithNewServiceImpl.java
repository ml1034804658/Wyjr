package com.jr.question.service.impl;

import com.jr.entity.Tb_Question;
import com.jr.question.dao.QuestionWithNewDao;
import com.jr.question.entity.QuestionAnswerVo;
import com.jr.question.service.QuestionWithNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionWithNewServiceImpl implements QuestionWithNewService{

    @Autowired
    private QuestionWithNewDao questionWithNewDao;


    @Override
    public List<QuestionAnswerVo> findAllNewest() {

        return questionWithNewDao.findAllWithNew();
    }
}
