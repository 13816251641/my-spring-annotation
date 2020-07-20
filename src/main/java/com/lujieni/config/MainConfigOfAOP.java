package com.lujieni.config;


import com.lujieni.aop.LogAspects;
import com.lujieni.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * AOP:
 *       指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式;
 *
 * 1.导入aop模式:spring aop:(spring-aspects)
 * 2.定义一个业务逻辑类(MathCalculator);在业务逻辑运行的时候将日志进行打印(方法之前、方法运行结束、方法出现异常)
 * 3.定义一个日志切面类(LogAspects):切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行
 *      通知方法:
 *          前置通知(@Before):logStart:在目标方法(div)运行之前运行
 *          后置通知(@After):logEnd:在目标方法(div)运行结束之后运行
 *          返回通知(@AfterReturning):logReturn:在目标方法(div)正常返回之后运行
 *          异常通知(@AfterThrowing):logException:在目标方法(div)出现异常以后运行
 *          环绕通知(@Around):动态代理,手动推进目标方法运行(joinPoint.procced())
 *
 * 4.给切面类的目标方法标注标注何时何地运行(通知注解);
 * 5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中;
 * 6.必须诉spring哪个类是一个切面类(给切面类上加一个注解:@Aspect)
 * 7.给配置类中加@EnableAspectJAutoProxy [开启基于注解的aop模式]
 *
 * 三步
 * 1).将业务逻辑组件和切面类都加入到容器中,告诉spring哪个是切面类(@Aspect)
 * 2).在切面类上的每个通知方法上标注通知注解,告诉spring何时何地运行(切入点表达式)
 * 3).开启基于注解的aop模式:@EnableAspectJAutoProxy
 *
 * AOP原理:给容器注册了什么组件,这个组件什么时候工作,这个组件的功能是什么?
 * @EnableAspectJAutoProxy
 * 1.@EnableAspectJAutoProxy是什么?
 *      @Import(AspectJAutoProxyRegistrar.class):给容器中导入AspectJAutoProxyRegistrar
 *      利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 *      internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *
 *   给容器中注册一个AnnotationAwareAspectJAutoProxyCreator;
 *
 * 2.
 *  AnnotationAwareAspectJAutoProxyCreator的基类AbstractAutoProxyCreator
 *      implements SmartInstantiationAwareBeanPostProcessor,BeanFactoryAware 关注后置处理器(在bean初始化完成前后做事情) 自动注入BeanFactory
 *
 * AbstractAutoProxyCreator.setBeanFactory()   因为它实现了BeanFactoryAware接口
 * AbstractAutoProxyCreator.有后置处理器的逻辑   因为它实现了BeanPostProcessor接口
 *
 * AbstractAdvisorAutoProxyCreator.setBeanFactory()重写了基类的setBeanFactory()方法,代码会调用本类的initBeanFactory()
 * AnnotationAwareAspectJAutoProxyCreator.initBeanFactory() 子类重写了基类的initBeanFactory方法
 *
 * 流程:
 *      1)、传入配置类,创建ioc容器
 *      2)、注册配置类,调用refresh()刷新容器
 *      3)、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *          1)、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *          2)、给容器中加别的BeanPostProcessor
 *          3)、优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *          4)、再给容器中注册实现了Ordered接口的BeanPostProcessor
 *          5)、注册没有实现优先级接口的BeanPostProcessor
 *          6)、注册BeanPostProcessor,实际上就是创建BeanPostProcessor对象,保存在容器中;
 *              1)、创建bean实例
 *              2)、populateBean,给bean的各种属性赋值
 *              3)、initializeBean:初始化bean:
 *                      1)、invokeAwareMethods():处理Aware接口的方法回调
 *                      2)、applyBeanPostProcessorsBeforeInitialization():应用后置处理器的postProcessBeforeInitialization
 *                      3)、invokeInitMethods():执行自定义的初始化方法
 *                      4)、applyBeanPostProcessorsAfterInitialization():执行后置处理器的postProcessAfterInitialization
 *              4)、BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功; -->>aspectJAdvisiorsBuilder
 *          7)、把BeanPostProcessor注册到BeanFactory中:
 *              beanFactory.addBeanPostProcessor(postProcessor);
 * =================以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程=================
 *     4)、finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作;创建剩下的单实例
 *         1)、遍历获取容器中所有的Bean,依次创建对象getBean(beanName);
 *             getBean->doGetBean()->getSingleton()->
 *         2)、创建bean
 *           1)、先从缓存中获取当前bean,如果能获取到,说明bean是之前被创建过的,直接使用,否则再创建
 *               只要创建好的Bean都会被缓存起来
 *           2)、createBean();创建bean
 *              1)、resolveBeforeInstantiation(beanName,mbdToUse);解析Before
 *
 */



@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

    /**
     * 业务逻辑类
     * @return
     */
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    /**
     * 切面类
     * @return
     */
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }




}