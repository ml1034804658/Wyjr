package com.jr.api.service;

import com.jr.common.vo.R;
import com.jr.entity.Tb_User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserProvider")
public interface Tb_UserService {

    //查询
    @GetMapping("user/all.do")
    R all();
    //新增
    @PostMapping("user/save.do")
    R save(@RequestBody Tb_User user);
    //校验手机号是否存在
    @GetMapping("user/checkphone.do")
    R check(@RequestParam("phone") String phone);

    // 查询我的捡人信息
    @GetMapping("api/tbfindothers/findByUid.do")
    R findByTbFindothers();
}
