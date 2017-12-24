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
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;
/**
 * Created by zcy on 2017/12/21.
 */
@Configuration
@ConditionalOnBean(name="Zcydatasource")
public class ZcySqlSession {

    @Autowired
    private DataSource Zcydatasource;

    @Bean(name = "zcysqlSessionFactory")
    public SqlSessionFactory zcysqlSessionFactory()throws Exception{
        SqlSessionFactoryBean  sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(Zcydatasource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="zcysqlSessionTemplate")
    public SqlSessionTemplate zcysqlSessionTemplate()throws Exception{
         SqlSessionTemplate template = new SqlSessionTemplate(zcysqlSessionFactory());
         zcysqlSessionFactory().getConfiguration();
         return  template;
    }

}
