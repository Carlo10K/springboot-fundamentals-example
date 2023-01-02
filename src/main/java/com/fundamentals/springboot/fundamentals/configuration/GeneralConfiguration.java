package com.fundamentals.springboot.fundamentals.configuration;

import com.fundamentals.springboot.fundamentals.bean.BeanWithProperties;
import com.fundamentals.springboot.fundamentals.bean.BeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
