package com.lujieni.test;

import com.lujieni.bean.Color;
import com.lujieni.bean.Person;
import com.lujieni.config.*;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @Auther ljn
 * @Date 2020/2/16
 * 基于xml方式装配
 */
public class IocTestInXml {

    /**
     * 使用xml方式装载bean
     */
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)applicationContext.getBean("lujieni");
        System.out.println(person);
    }

    /**
     * 使用javaConfig,利用@Bean标签装载bean
     */
    @Test
    public void test02(){
        /* MainConfig类上可以不加@Configuration,猜测是因为这里已经指定了MainConfig.class */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person)applicationContext.getBean("showPerson");
        System.out.println(person);
    }

    /**
     * 使用javaConfig,利用@Componentscan标签装载bean
     */
    @Test
    public void test03(){
        /* MainConfigWithComponetscan类上可以不加@Configuration,猜测是因为这里已经指定了MainConfigWithComponetscan.class */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigWithComponetscan.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String str : beanDefinitionNames){
            System.out.println(str);
        }
    }

    /**
     * 使用javaConfig并使用@Scope
     */
    @Test
    public void test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person1 =(Person) applicationContext.getBean("person");
        Person person2 =(Person) applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }

    /**
     * 使用javaConfig并使用@Scope
     */
    @Test
    public void test05(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");//获取环境变量的值
        System.out.println(property);

        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }



    /**
     * 使用javaConfig并使用@Import
     */
    @Test
    public void test06(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            System.out.println(name);
        }
    }

    /**
     * 使用javaConfig并使用工厂Bean
     * 注意这里的colorFactoryBean已经是Color类了!!!
     */
    @Test
    public void test07(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            System.out.println(name);
        }
        Color color = (Color)applicationContext.getBean("colorFactoryBean");
        System.out.println(color.getClass());
    }

}
