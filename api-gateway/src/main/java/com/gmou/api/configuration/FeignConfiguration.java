package com.gmou.api.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 设置feign内部日志打印格式
 * Created by admin on 2017/5/20.
 */
@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

}
