package com.jr.question.api.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "QuestionProvider")
public interface QuestionAddService {
    @PostMapping("/question/add.do")
    public R saveQuestion(@RequestBody Tb_Question question);
}
