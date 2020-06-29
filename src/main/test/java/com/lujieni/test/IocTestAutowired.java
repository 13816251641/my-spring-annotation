package com.lujieni.test;

import com.lujieni.config.BeanLifeConfig;
import com.lujieni.config.MainConfigOfAutowired;
import com.lujieni.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
public class IocTestAutowired {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bean = context.getBean(BookService.class);
        bean.print();
    }
}
