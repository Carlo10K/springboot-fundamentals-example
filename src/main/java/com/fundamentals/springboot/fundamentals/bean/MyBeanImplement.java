package com.fundamentals.springboot.fundamentals.bean;

public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia de del bean");
    }
}
