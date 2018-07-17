package com.iny.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zcy on 2018/1/1.
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Class target){

        this.target = target;
        Enhancer enchancer = new Enhancer();
        enchancer.setSuperclass(target);
        enchancer.setCallback(this);
        return enchancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.print("cglib代理开始");
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.print("cglib代理结束");
        return result;
    }
}
