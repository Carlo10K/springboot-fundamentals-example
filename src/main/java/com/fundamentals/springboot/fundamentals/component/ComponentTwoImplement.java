package com.fundamentals.springboot.fundamentals.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void sayHi() {
        System.out.println("Hi, from my component 2");
    }
}
