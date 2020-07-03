package com.futurell.JDK.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/2 12:24
 * @version: 1.0
 * @modified By:
 *
 * 如果是要实现CGLIB,需要先添加cglib依赖,然后实现一个接口MethodInterceptor,重写intercept()方法
 *
 * sub：cglib生成的代理对象
 * method：被代理对象方法
 * objects：方法入参
 * methodProxy: 代理方法
 *
 * @Override
 * public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
 *     System.out.println("======插入前置通知======");
 *     Object object = methodProxy.invokeSuper(sub, objects);
 *     System.out.println("======插入后者通知======");
 *     return object;
 * }
 */
public class FutureInvocationHandler implements InvocationHandler {

    Object target;

    public FutureInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 代理对象包含目标对象,目标对象中的方法,就是method
     * @param args 目标方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        return method.invoke(target, args);
    }
}
