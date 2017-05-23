package com.gmou.api.controller;

import com.gmou.api.service.client.ServiceAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/5/20.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private ServiceAClient serviceAClient;

    @RequestMapping("")
    public Object hello(@RequestParam("msg") String msg) {
        return serviceAClient.hello(msg);
    }

    @RequestMapping("/user/{id}")
    public Object user(@PathVariable("id") Long id) {
        return serviceAClient.user(id);
    }



}
