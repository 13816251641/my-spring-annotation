package com.lujieni.test;

import com.lujieni.bean.Person;
import com.lujieni.config.MainConfigOfProfile;
import com.lujieni.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @Auther lujieni
 * @Date 2020/6/28
 */
public class IocTestProfile {

    /**
     * 1.使用命令行行动参数:在虚拟机参数位置加载-Dspring.profiles.active=dev
     * 2.代码的方式激活某种环境
     */
    @Test
    public void test01(){
        //1.创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Environment environment = applicationContext.getEnvironment();
        //2.设置一个需要激活的环境
        environment.acceptsProfiles("dev","test");
        //3.注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for(String s : beanNamesForType){
            System.out.println(s);
        }
    }


}
