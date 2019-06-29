package com.wyjr.api.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient  //启用服务发现 去注册中心检索服务
@EnableFeignClients //启用Feign 消费服务
@EnableSwagger2  //启用Swagger
public class GoodsApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApiApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GoodsApiApplication.class);
    }
}
