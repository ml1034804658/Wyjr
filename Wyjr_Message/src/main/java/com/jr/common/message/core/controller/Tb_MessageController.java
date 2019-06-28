package com.jr.common.message.core.controller;

import com.jr.common.message.core.entity.Tb_Message;
import com.jr.common.message.core.service.Tb_MessageService;
import com.jr.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Tb_MessageController {
    @Autowired
    private Tb_MessageService messageService;

    @PostMapping("/message/sendmsg.do")
    public R sendMsg(Tb_Message message, HttpServletRequest request){
        return messageService.sendMessage(message,request.getRemoteAddr());
    }
    @GetMapping("/message/page.do")
    public R all(int page,int count){
        return messageService.page(page, count);
    }
    @GetMapping("/message/checkcode.do")
    public R check(String phone,int code){
        return messageService.checkCode(phone, code);
    }
}
