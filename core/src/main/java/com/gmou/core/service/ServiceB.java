package com.gmou.core.service;

import com.gmou.core.bean.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by admin on 2017/5/20.
 */
public interface ServiceB {

    @RequestMapping("/hello")
    public String hello(@RequestParam("msg") String msg);

    @RequestMapping("/user/{id}")
    public Person user(@PathVariable("id") Long id);

}
