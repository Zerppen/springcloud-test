package com.gmou.serviceb.service;

import com.gmou.core.bean.Person;
import com.gmou.core.service.ServiceB;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 2017/5/20.
 */
@RestController
@RequestMapping("service-b")
public class ServiceBResource implements ServiceB {

    static private Map<Long, Person> personMap = Maps.newHashMap();

    static {
        personMap.put(1L, new Person(1L, "Jack"));
        personMap.put(2L, new Person(2L, "Tom"));
        personMap.put(3L, new Person(3L, "Lucy"));
    }

    @Override
    public String hello(String msg) {
        return String.format("[%s from B]", msg);
    }

    @Override
    public Person user(@PathVariable("id") Long id) {
        Person person = personMap.get(id);
        if (person == null) {
            throw new IllegalStateException("Person with id[" + id + "] not exists");
        }
        person.append(" > from B");
        return person;
    }
}
