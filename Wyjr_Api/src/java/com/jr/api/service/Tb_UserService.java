package com.jr.api.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "UserProvider")
public interface Tb_UserService {

    //查询
    @GetMapping("user/all.do")
    R all();
    //新增
    @PostMapping("user/save.do")
    R save(@RequestBody Tb_User user);

}
