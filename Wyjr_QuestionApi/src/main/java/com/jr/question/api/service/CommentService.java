package com.jr.question.api.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_Question_Answer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="QuestionProvider")
public interface CommentService {
    @PostMapping("wd/comment.do")
    R saveComment(@RequestBody Tb_Question_Answer comment);

}
