package com.gmou.api.service.client;

import com.gmou.core.service.ServiceB;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by admin on 2017/5/8.
 */
@FeignClient(value = "service-b", path = "/service-b")
public interface ServiceAClient extends ServiceB {

}
