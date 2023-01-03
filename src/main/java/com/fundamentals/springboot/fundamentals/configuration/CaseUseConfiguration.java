package com.fundamentals.springboot.fundamentals.configuration;

import com.fundamentals.springboot.fundamentals.caseuse.GetUser;
import com.fundamentals.springboot.fundamentals.caseuse.GetUserImplements;
import com.fundamentals.springboot.fundamentals.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplements(userService);
    }
}
