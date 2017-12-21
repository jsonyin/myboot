package com.yin.myboot.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by zcy on 2017/12/21.
 */
@Configuration
@ConditionalOnBean(name="Yindatasource")
@MapperScan(basePackages = "classpath:/mapper/yin",sqlSessionFactoryRef = "yinsqlSessionFactory")
public class YinSqlsession {
    @Autowired
    private DataSource Yindatasource;

    @Bean(name = "yinsqlSessionFactory")
    public SqlSessionFactory yinsqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(Yindatasource);
        return sessionFactory.getObject();
    }

    @Bean(name = "yinSqlsessionTemplate")
    public SqlSessionTemplate yinSqlsessionTemplate()throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(yinsqlSessionFactory());
        return template;
    }
}
