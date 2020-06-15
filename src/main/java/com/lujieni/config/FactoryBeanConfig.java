package com.lujieni.config;

import com.lujieni.factory.ColorFactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @Auther lujieni
 * @Date 2020/6/15
 * 使用Spring提供的FactoryBean(工厂Bean)
 */
public class FactoryBeanConfig {


    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }


}
