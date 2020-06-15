package com.lujieni.config;

import com.lujieni.bean.Person;
import com.lujieni.condition.LinuxCondition;
import com.lujieni.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @Auther lujieni
 * @Date 2020/6/4
 */
/*
    @Conditional放在类上如果不满足条件的话类中
    所有Bean都不会生效!!!
    @Conditional(WindowsCondition.class)
 */
public class ConditionalConfig {

    /**
     * @Conditional({Condition}):按照一定的条件进行判断,满足条件给容器中注册bean
     * 如果系统是Windows,给容器中注册bill
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person().setName("Bill Gates").setAge(62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person().setName("Linus").setAge(58);
    }

    @Bean
    public Person person03(){
        return new Person().setName("alone").setAge(20);
    }






}
