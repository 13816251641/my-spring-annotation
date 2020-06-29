package com.lujieni.config;

import com.lujieni.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther lujieni
 * @Date 2020/6/28
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完毕外部的配置文件以后可以使用
//@Value("${}")取出配置文件的值
@PropertySource(value = {"classpath:person.properties"})
public class MainConfigOfPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }





}
