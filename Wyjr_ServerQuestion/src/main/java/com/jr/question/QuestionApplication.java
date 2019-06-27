package com.jr.question;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.jr.question.dao")
@EnableEurekaClient
@EnableTransactionManagement
public class QuestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class,args);
    }
}
