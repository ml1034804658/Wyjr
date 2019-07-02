package com.jr.question.api.service;

import com.jr.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "QuestionProvider")
public interface QuestionDetailService {
    @GetMapping("/question/selectQDetail.do")
    public R getQuestionDetail(@RequestParam Long qid);

    @GetMapping("/question/selectQAnswer.do")
    public R getQuestionAnswer(@RequestParam Long qid);
}
