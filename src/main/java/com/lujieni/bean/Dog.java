package com.lujieni.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Auther lujieni
 * @Date 2020/6/18
 * 实现ApplicationContextAware接口可以获得上下文容器
 */
@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Dog(){
        System.out.println("dog constructor...");
    }

    /**
     * init方法会在setApplicationContext()方法之后执行
     */
    @PostConstruct
    public void init(){
        System.out.println("dog @PostConstruct ...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("dog @PreDestroy ... ");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
