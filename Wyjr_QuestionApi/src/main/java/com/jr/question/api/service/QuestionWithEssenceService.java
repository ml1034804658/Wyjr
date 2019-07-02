package com.jr.question.api.service;

import com.jr.entity.Tb_Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="QuestionProvider")
public interface QuestionWithEssenceService {

    @GetMapping("/question/essence.do")
    List<Tb_Question> findAllWithEssence();

}
