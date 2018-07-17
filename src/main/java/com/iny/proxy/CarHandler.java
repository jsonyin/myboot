package com.iny.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zcy on 2017/12/27.
 */
public class CarHandler implements InvocationHandler {


    private Object obj;


    public CarHandler(Object obj){
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if("2"!= null) {
            System.out.println("start proxy");
            result=method.invoke(obj,args);
            System.out.println("end proxy");
        }
        return result;
    }
}
