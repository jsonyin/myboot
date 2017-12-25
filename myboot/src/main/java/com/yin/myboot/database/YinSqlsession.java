package com.yin.myboot.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by zcy on 2017/12/21.
 */
@Configuration
@ConditionalOnBean(name="Yindatasource")
public class YinSqlsession {
    @Autowired
    private DataSource Yindatasource;

    @Bean(name = "yinsqlSessionFactory")
    public SqlSessionFactoryBean yinsqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*Mapper.xml"));
        sessionFactory.setDataSource(Yindatasource);
        return sessionFactory;
    }

    @Bean(name = "yinSqlsessionTemplate")
    public SqlSessionTemplate yinSqlsessionTemplate()throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(yinsqlSessionFactory().getObject());
        return template;
    }
}
