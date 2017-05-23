package com.gmou.api.configuration;

import com.netflix.config.ConfigurationManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 设置全局的HystrixClient的参数
 * 也可以通过commandKey设置单个请求的:ServiceAClient#hello(String)
 * Created by admin on 2017/5/20.
 */
@Deprecated
@Component
public class HystrixClientConfiguration {

    @PostConstruct
    public void configuration() {
        set();
    }


    public void set() {
        // https://github.com/Netflix/Hystrix/wiki/Configuration
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.requestVolumeThreshold", "5");
    }

}
