package com.fundamentals.springboot.fundamentals.bean;

public class BeanWithPropertiesImplement implements BeanWithProperties{
    private String name;
    private String lastname;

    public BeanWithPropertiesImplement(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String function() {
        return name +"-"+lastname;
    }
}
