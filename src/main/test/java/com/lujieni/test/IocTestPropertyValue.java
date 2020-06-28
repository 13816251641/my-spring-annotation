package com.lujieni.test;

import com.lujieni.bean.Person;
import com.lujieni.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther lujieni
 * @Date 2020/6/28
 */
public class IocTestPropertyValue {


    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);

    }


}
