package com.jr.api.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *@Author feri
 *@Date Created in 2019/6/3 14:45
 * Swagger设置
 */
@Configuration //标记这是一个配置
public class SwaggerConfig {

    public ApiInfo createA(){
        ApiInfo info=new ApiInfoBuilder().title("我要检人-数据接口平台").

                description("实现一个我要检人项目的数据接口").build();
        return info;
    }
    @Bean//创建对象  修饰方法 方法的返回值必须是引用类型  对象存储在IOC容器
    public Docket createDocket(){
       Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(createA()).select().
               apis(RequestHandlerSelectors.basePackage("com.jr.api.resource.controller")).build();
       return docket;

    }
}
