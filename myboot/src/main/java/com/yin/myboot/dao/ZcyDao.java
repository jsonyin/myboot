package com.yin.myboot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zcy on 2017/12/21.
 */
public class ZcyDao<T> {
    //留给继承的类用
    @Autowired
    protected SqlSessionTemplate zcySessionTemplate;
    protected String namespace;

    public ZcyDao(){
        //this.getClass().getGenericSuperclass() 返回此class的
        if(this.getClass().getGenericSuperclass() instanceof ParameterizedType){
            this.namespace = ((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        }else {
            this.namespace = ((Class)((ParameterizedType)this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        }
    }
    public boolean create(T t){
        return (this.zcySessionTemplate.insert(this.namespace+".create",t)==1);
    }

    public boolean delete(Long id){
        return(this.zcySessionTemplate.delete(this.namespace+".delete",id)==1);
    }

    public T selectOne(Long id){
        return this.zcySessionTemplate.selectOne(this.namespace+".selectOne",id);
    }

}
