package com.fundamentals.springboot.fundamentals.configuration;

import com.fundamentals.springboot.fundamentals.bean.MyBean;
import com.fundamentals.springboot.fundamentals.bean.MyBean2Implement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }
}
