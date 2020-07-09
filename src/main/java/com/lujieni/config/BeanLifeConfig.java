package com.lujieni.config;

import com.lujieni.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 *
 * bean的生命周期
 *      bean创建---初始化---销毁的过程
 *
 *容器管理bean的生命周期:
 *我们可以自定义初始化和销毁方法;容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造(对象创建)
 *      单实例:在容器启动的时候创建对象
 *      多实例:在每次获取的时候创建对象
 *
 * 1) 指定初始化和销毁方法;
 *      通过@Bean指定init-method和destroy-method
 * 2) 通过让Bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
 * 3) 可以使用JSR250:
 *      @PostConstruct:在bean创建完成并且属性赋值完成来执行初始化方法
 *      @PreDestroy:在容器销毁bean之前通知我们进行清理工作
 * 4) BeanPostProcessor[interface]:bean的后置处理器
 *      在bean初始化前后进行一些处理工作:
 *      postProcessBeforeInitialization:在初始化之前工作
 *      postProcessAfterInitialization:在初始化之后工作
 *
 *
 * populateBean(beanName, mbd, instanceWrapper);处理bean中的Autowired注解
 * initializeBean{
 *     applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);//before
 *     invokeInitMethods(beanName, wrappedBean, mbd);//1.InitializingBean接口的方法  2.@Bean指定init-method方法
 *     applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);//after
 * }
 *
 *
 *
 *
 *
 * Spring底层对BeanPostProcessor的使用:
 *  bean赋值;注入其他组件;@Autowired;
 *  实现了ApplicationContextAware接口就可以获得上下文对象,
 *  原理是ApplicationContextAwareProcessor这个类(实现了BeanPostProcessor接口),
 *  里面对实现ApplicationContextAware接口的类做了处理哦
 *
 *  AutowiredAnnotationBeanPostProcessor
 *
 * 销毁:
 *      单实例:容器关闭的时候
 *      多实例:容器不会管理这个bean
 */
//@ComponentScan("com.lujieni.bean,com.lujieni.processor") //把Cat Dog扫描进来了;将后置处理器扫描进来
public class BeanLifeConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }





}
