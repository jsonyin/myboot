package com.yin.myboot.database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(AllDataSource.class);

    @Bean(name="Zcydatasource")
    @ConfigurationProperties(prefix = "spring.datasource.zcy")
    public DataSource zcyDatasource(){
        log.debug("zcy datasource create");
        return DataSourceBuilder.create().build();
    }


    @Bean(name="Yindatasource")
    @ConfigurationProperties(prefix = "spring.datasource.yin")
    public DataSource yinDatasource(){
        log.debug("yin datasource create");
        return DataSourceBuilder.create().build();
    }
}
