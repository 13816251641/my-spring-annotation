package com.lujieni.bean;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
public class Car {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car使用initMethod参数 init...");
    }

    public void destroy(){
        System.out.println("car使用destroyMethod参数 destroy...");
    }

}
