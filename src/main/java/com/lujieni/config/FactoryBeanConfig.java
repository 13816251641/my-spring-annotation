package com.lujieni.config;

import com.lujieni.factory.ColorFactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @Auther lujieni
 * @Date 2020/6/15
 * 使用Spring提供的FactoryBean(工厂Bean)
 * 1).默认获取到的是工厂bean调用getObject创建的对象
 * 2).要获取工厂Bean本身,我们需要给id前面加一个& 例如:&colorFactoryBean
 */
public class FactoryBeanConfig {


    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }


}
