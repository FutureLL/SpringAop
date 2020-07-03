package com.futurell.app;

import com.futurell.dao.Dao;
import com.futurell.dao.IndexDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 18:33
 * @version: 1.0
 * @modified By:
 */
@Component
@Aspect
public class FutureAspectJ {

    // 找到value路径下的所有的类,引入Dao接口的IndexDao实现类
    // @DeclareParents(value = "com.futurell.dao.*", defaultImpl = IndexDao.class)
    // public static Dao dao;

    /**
     * * com.futurell.dao.IndexDao.*(..)
     * 第一个 *: 表示方法返回类型
     * 第二个 *: 表示indexDao类中的所有方法
     * (..): 任意参数
     */
    @Pointcut("execution(* com.futurell.dao.IndexDao.*(..))")
    public void pointCutExecution() {

    }

    @Pointcut("within(com.futurell.dao.IndexDao.*)")
    public void pointCutWithin() {

    }

    @Pointcut("args(java.lang.String)")
    public void pointCutArgs() {

    }

    // this: 当前对象,也就是代理对象,此时为Dao
    @Pointcut("this(com.futurell.dao.IndexDao)")
    public void pointCutThis() {

    }

    // target: 目标对象,此时为IndexDao
    @Pointcut("target(com.futurell.dao.IndexDao)")
    public void pointCutTarget() {

    }

    @Pointcut("within(com.futurell.dao.*)")
    public void pointCutAround() {

    }

    /**
     * 切点之前
     * 其他类型: @Before("pointCutArgs() && !pointCutWithin()") 也可以使用 &&
     */
    // @Before("pointCutAround()")
    // public void before(JoinPoint joinPoint) {
    //     System.out.println("before");
    //     System.out.println(joinPoint.getThis());
    // }

    /**
     * 切点之后
     */
    // @After("pointCutAround()")
    // public void after() {
    //     System.out.println("after");
    // }

    /**
     * 环绕通知
     */
    @Around("pointCutAround()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                args[i] += " World！";
            }
        }
        System.out.println("Before");
        try {
            proceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("After");
    }
}
