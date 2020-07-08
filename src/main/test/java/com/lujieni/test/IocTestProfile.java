package com.lujieni.test;

import com.lujieni.bean.Person;
import com.lujieni.config.MainConfigOfProfile;
import com.lujieni.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @Auther lujieni
 * @Date 2020/6/28
 */
public class IocTestProfile {


    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for(String s : beanNamesForType){
            System.out.println(s);
        }
    }


}
