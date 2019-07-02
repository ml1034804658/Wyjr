package com.jr.api.service;

import com.jr.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "UserProvider")
public interface Tb_FindothersService {
    @GetMapping("tbfindothers/findByUid.do")
    public R findByTbFindothers();
}
