package com.yin.myboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages = "com.yin.myboot.dao")
public class MyBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}
}
