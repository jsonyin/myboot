package com.yin.myboot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zcy on 2017/12/21.
 */
public class YinDao<T> {

    protected SqlSessionTemplate yinSqlsessionTemplate;

    @Autowired
    public void setYinSqlsessionTemplate(@Qualifier("yinSqlsessionTemplate")SqlSessionTemplate yinSqlsessionTemplate ){
        this.yinSqlsessionTemplate = yinSqlsessionTemplate;
    }

    protected String namespace;

    public YinDao(){
        //this.getClass().getGenericSuperclass() 返回此class的
        if(this.getClass().getGenericSuperclass() instanceof ParameterizedType){
            this.namespace = ((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        }else {
            this.namespace = ((Class)((ParameterizedType)this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        }
    }

    public boolean create(T t){
        return (this.yinSqlsessionTemplate.insert(this.namespace+".create",t)==1);
    }

    public boolean delete(Long id){
        return(this.yinSqlsessionTemplate.delete(this.namespace+".delete",id)==1);
    }

    public T selectOne(Long id){
        return this.yinSqlsessionTemplate.selectOne(this.namespace+".selectOne",id);
    }
}
