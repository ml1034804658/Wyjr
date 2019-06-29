package com.jr.server.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2  //启用Swagger
@EnableTransactionManagement  //开启事务管理
@EnableEurekaClient  //服务提供者
@MapperScan("com.jr.server.goods.dao")  //扫描Dao
public class GoodsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServerApplication.class,args);
    }
}
