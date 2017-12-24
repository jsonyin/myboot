package com.yin.myboot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zcy on 2017/12/21.
 */
public class ZcyDao<T> {
    //留给继承的类用

    protected SqlSessionTemplate zcysqlSessionTemplate;

    @Autowired
    protected void setZcySessionTemplate(@Qualifier("zcysqlSessionTemplate") SqlSessionTemplate zcysqlSessionTemplate){
        this.zcysqlSessionTemplate = zcysqlSessionTemplate;
    }
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
        return (this.zcysqlSessionTemplate.insert(this.namespace+".create",t)==1);
    }

    public boolean delete(Long id){
        return(this.zcysqlSessionTemplate.delete(this.namespace+".delete",id)==1);
    }

    public List<T> findByIds(List<Long> ids){
       return this.zcysqlSessionTemplate.selectList(this.namespace+".selectByIds",ids);
    }

    public T selectOne(Long id){
        return this.zcysqlSessionTemplate.selectOne(this.namespace+".selectOne",id);
    }

}
