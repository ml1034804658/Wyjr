package com.qianfeng.wyjr.server.findone;

import com.qianfeng.wyjr.server.findone.job.main.utils.CRONutil;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  //开启事务管理
@EnableEurekaClient  //服务提供者
@MapperScan("com.qianfeng.wyjr.server.findone.dao")  //扫描Dao
/*@EnableScheduling*/
public class FindOneApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(FindOneApplication.class,args);
        try {
            new CRONutil().Cron();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FindOneApplication.class);
    }

}
