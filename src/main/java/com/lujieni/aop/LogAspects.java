package com.lujieni.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 *
 * @Aspect 告诉spring当前类是一个切面类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用
    //2.其他的切面引用
    @Pointcut("execution( public int com.lujieni.aop.MathCalculator.*(..) )")
    public void pointCut(){

    }

    //@Before在目标方法之前切入;切入点表达式(指定在哪个方法切入)
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(name+"运行...@Before参数列表:"+ Arrays.asList(args));
    }

    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束...@After");
    }

    /**
     *
     * @param joinPoint 一定要出现在参数表的第一位
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Integer result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回...@AfterReturning运行结果:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法异常...异常信息:"+exception);
    }


}