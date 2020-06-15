package com.lujieni.registry;

import com.lujieni.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther lujieni
 * @Date 2020/6/12
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @param registry  bean注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean result = registry.containsBeanDefinition("com.lujieni.bean.Red");
        if(result){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);//指定bean定义信息
            registry.registerBeanDefinition("rainBow123",rootBeanDefinition);//注册一个Bean,指定bean名
        }
    }
}
