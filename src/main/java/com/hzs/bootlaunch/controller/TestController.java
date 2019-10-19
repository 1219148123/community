package com.hzs.bootlaunch.controller;

import com.hzs.bootlaunch.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/test")
    public String goTest() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("name","zhangsan");
        Object name = operations.get("name");
        System.out.println(String.valueOf(name));
        return "test";
    }
}
