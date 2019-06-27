package com.qfedu.wyjr.api.findone;

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
public class FindOneApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FindOneApiApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FindOneApiApplication.class);
    }
}
