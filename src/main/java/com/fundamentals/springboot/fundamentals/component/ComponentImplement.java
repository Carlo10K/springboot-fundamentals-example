package com.fundamentals.springboot.fundamentals.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void sayHi() {
        System.out.println("Hi, from my component");
    }
}
