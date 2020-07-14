package com.lujieni.test;


import com.lujieni.aop.MathCalculator;
import com.lujieni.config.MainConfigOfAOP;
import com.lujieni.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

/**
 *
 */
public class IocTestAOP {

    @Test
    public void test01(){
        //1.创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);


        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(0, 0);

    }


}
