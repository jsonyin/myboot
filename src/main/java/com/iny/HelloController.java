package com.iny;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zcy on 2017/9/3.
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(){
        return "Hello Spring Boot";
    }
}
