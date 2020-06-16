package com.lujieni.test;

import com.lujieni.config.BeanLifeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
public class IocBeanLifeTestInXml {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeConfig.class);
        context.close();
    }
}
