package com.fundamentals.springboot.fundamentals.bean;

public class MyBean2Implement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia de del bean 2");
    }
}
