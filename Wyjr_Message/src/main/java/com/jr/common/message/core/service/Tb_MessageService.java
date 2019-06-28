package com.jr.common.message.core.service;

import com.jr.common.message.core.entity.Tb_Message;
import com.jr.common.vo.R;

public interface Tb_MessageService {

    R sendMsg(Tb_Message message, String ip);
    R page(int page, int count);
    R checkCode(String phone, int code);
    R sendMessage(Tb_Message message, String ip);
}
