package com.yin.myboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by zcy on 2017/12/13.
 */
@ControllerAdvice(basePackages = "com.example.demo")
public class JsonpAdvide extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvide(){
        super("callback","jsonp");
    }

}
