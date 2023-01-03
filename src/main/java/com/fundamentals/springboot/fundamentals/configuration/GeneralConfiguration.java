package com.fundamentals.springboot.fundamentals.configuration;

import com.fundamentals.springboot.fundamentals.bean.BeanWithProperties;
import com.fundamentals.springboot.fundamentals.bean.BeanWithPropertiesImplement;
import com.fundamentals.springboot.fundamentals.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    public BeanWithProperties function(){
        return new BeanWithPropertiesImplement(name,lastname);
    }

    @Bean
    public DataSource dataSource (){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb;NON_KEYWORDS=USER");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
