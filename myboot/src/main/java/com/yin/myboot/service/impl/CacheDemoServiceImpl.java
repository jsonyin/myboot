package com.yin.myboot.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zcy on 2018/7/5.
 */
@Service
public class CacheDemoServiceImpl {

    @Cacheable(value = "demo", key = "#root.methodName")
    public String sayHello(){
        return heihei();
    }


    @Cacheable(value = "demo", key="#id")
    public String selectById(String id){
        return sayMyId(id);
    }

    /**
     * CacheEvict 的参数解析
     * value 刷新缓存域的名称
     * allEntries 是否清除缓存中所有参数
     * beforeInvocation 在方法运行成功后清除缓存
     * @return
     */

    @CacheEvict(value = "demo")
    public String flushCashe(){
        return "刷新完成";
    }

    private String heihei(){
        System.out.print("我进来了");
        return "hello 123";
    }

    private String sayMyId(String id){
        System.out.print("我进来了");
        return id;
    }
}
