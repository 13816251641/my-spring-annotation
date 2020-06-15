package com.lujieni.config;
import com.lujieni.bean.Person;
import org.springframework.context.annotation.Bean;
/**
 * @Auther ljn
 * @Date 2020/2/15
 * 基于配置类
 */
//@Configuration //告诉spring这是一个配置类
public class MainConfig {

    @Bean(name = "showPerson") //id默认是方法名,可以使用name来覆盖
    public Person person(){
        return new Person().setAge(27).setName("张飞");
    }

}
