package com.bug.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面
 */
@Component
@Aspect
public class AspectTest {

    /**
     *      格式   访问修饰符(可省略) 返回值 包名.类名.方法名（参数类型列表）
     *      *  通配符代表所有
     *      .. 当前包及其子包
     *      方法参数：()
     *              *表示所有参数类型（必须有参数）
     *              ..表示有无参数均可
     *
     */
    @Pointcut(value = "execution(* com.bug.service..*.*(..))")
    public void pointCount(){}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("pointCount()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知");
        System.out.println("被增强的方法签名-----------"+joinPoint.getSignature());
        System.out.println("被增强的方法名-----------"+joinPoint.getSignature().getName());
        System.out.println("被增强的方法参数数组-----------"+ Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * 后置通知
     */
    @After(value = "pointCount()")
    public void After(){
        System.out.println("---------后置通知-----------");
    }

    /**
     * 后置返回通知
     * @param joinPoint
     * @param re
     */
    @AfterReturning(value = "pointCount()",returning = "re", argNames = "joinPoint,re")
    public void AfterReturning(JoinPoint joinPoint, Object re){
        System.out.println(joinPoint.getSignature().toShortString());

        System.out.println("--------后置返回通知 返回--------"+re);
    }

    /**
     * 后置异常通知
     * @param exception
     */
    @AfterThrowing(value = "pointCount()",throwing = "exception")
    public void AfterThrowing(Exception exception  ){
        System.out.println("-----------"+"异常通知");
    }

    /**
     * 环绕通知
     * @param pJoinPoint
     */
    @Around("execution(* com.bug.service.*.*(..))")
    public void around(ProceedingJoinPoint pJoinPoint){
        System.out.println("----------环绕通知调用方法-----"+pJoinPoint.getSignature().getName());
        Object obj=null;
        try {
               obj=pJoinPoint.proceed();
            System.out.println("执行原方法");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            System.out.println("---环绕通知结束---");
        }

    }

}
