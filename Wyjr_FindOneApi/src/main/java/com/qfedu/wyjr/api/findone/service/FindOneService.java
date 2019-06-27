package com.qfedu.wyjr.api.findone.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "FindOneProvider")
public interface FindOneService {
}
