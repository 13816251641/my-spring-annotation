package com.lujieni.config;
import com.lujieni.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @Auther ljn
 * @Date 2020/2/15
 * 基于配置类
 */
public class MainConfig2 {

    /**
     * prototype:多实例:ioc容器启动并不会去调用方法创建对象放在容器中,每次获取的时候才会调用方法创建对象
     * singleton:单实例(默认值):ioc容器启动会调用方法创建对象放到ioc容器中,以后每次获取就是直接从容器中拿
     * request:同一个请求创建一个实例
     * session:同一个session创建一个实例
     * @return
     */
    @Scope("prototype")
    @Bean
    public Person person(){
        System.out.println("创建person");
        return new Person().setAge(37).setName("刘备");
    }

}
