package com.yin.myboot.database;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by zcy on 2017/12/21.
 */
@Configuration
public class AllDataSource {

    @Bean(name="Zcydatasource")
    //@ConditionalOnProperty(prefix ="spring.datasource.zcy")
    @ConfigurationProperties(prefix = "spring.datasource.zcy")
    public DataSource zcyDatasource(){
        return DataSourceBuilder.create().build();
    }


    @Bean(name="Yindatasource")
    //@ConditionalOnProperty(prefix ="spring.datasource.yin")
    @ConfigurationProperties(prefix = "spring.datasource.yin")
    public DataSource yinDatasource(){
        return DataSourceBuilder.create().build();
    }


}
