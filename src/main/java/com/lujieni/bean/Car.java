package com.lujieni.bean;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
public class Car implements InitializingBean {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car使用@Bean中initMethod参数 init...");
    }

    public void destroy(){
        System.out.println("car使用@Bean中destroyMethod参数 destroy...");
    }

    @PostConstruct
    public void show(){
        System.out.println("使用@PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口的实现方法");
    }
}
