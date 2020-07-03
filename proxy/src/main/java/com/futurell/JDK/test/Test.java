package com.futurell.JDK.test;

import com.futurell.JDK.dao.FutureDao;
import com.futurell.JDK.dao.FutureDaoImpl;
import com.futurell.JDK.proxy.FutureInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @description: 测试
 * @author: Mr.Li
 * @date: Created in 2020/7/1 10:56
 * @version: 1.0
 * @modified By:
 */
public class Test {

    public static void main(String[] args) {

        FutureDao jdkProxy = (FutureDao) Proxy.newProxyInstance(
                // getClassLoader(): Returns the class loader for the class.
                // 判断一个类是否相同,需要根据类加载器是否相同来判断,为了保证加载器可用,那么传入当前所在类的ClassLoader
                // 在自定义动态代理的代码中,使用了URLClassLoader,因为自定义的类不在工程当中
                Test.class.getClassLoader(),
                // Class targetInf = target.getClass().getInterfaces()[0];
                // 自定义使用了上边的代码,我们需要得到接口,用来得到接口中的方法,然后对方法进行代理
                new Class[]{FutureDao.class},
                new FutureInvocationHandler(new FutureDaoImpl()));

        jdkProxy.query();
        System.out.println("--------------");
        System.out.println(jdkProxy.returnString());
    }
}
