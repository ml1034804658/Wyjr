package com.jr.question.service.impl;

import com.jr.entity.Tb_Question;
import com.jr.question.dao.QuestionDao;
import com.jr.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questiondao;


    @Override
    public List<Tb_Question> findAllquestion() {

        return questiondao.findAll();
    }
}
