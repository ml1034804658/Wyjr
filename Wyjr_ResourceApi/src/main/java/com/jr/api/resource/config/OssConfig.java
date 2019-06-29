package com.jr.api.resource.config;

import com.jr.api.resource.util.OSSUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OssConfig {
    @Bean
    public OSSUtil createOSS(){
        return new OSSUtil();
    }
}