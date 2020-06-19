package com.lujieni.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Auther lujieni
 * @Date 2020/6/17
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("cat constructor");
    }

    public void destroy() throws Exception {
        System.out.println("cat 实现DisposableBean接口 destroy...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat 实现InitializingBean接口 afterPropertiesSet...");
    }
}
