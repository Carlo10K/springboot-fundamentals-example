package com.fundamentals.springboot.fundamentals.configuration;

import com.fundamentals.springboot.fundamentals.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOp(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOpWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}

