package com.futurell.test;

import com.futurell.app.Appconfig;
import com.futurell.dao.Dao;
import com.futurell.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 17:14
 * @version: 1.0
 * @modified By:
 *
 * 问: JDK动态代理为什么只能基于接口
 * 答: JDK底层源码已经帮代理对象自动继承了Proxy这个类,由于Java是单继承语法,所以不可能再去继承目标对象,只能去实现目标对象
 */
public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        // 此时目标对象为IndexDao,代理对象为Dao
        // this: 当前对象,也就是代理对象
        // target: 目标对象
        Dao dao = (Dao) context.getBean("indexDao");
        // System.out.println(dao instanceof IndexDao);
        // System.out.println(dao instanceof Proxy);
        dao.query("query");

        // 测试@DeclareParents注解
        // Dao dao = (Dao) context.getBean("orderDao");
        // dao.query("orderDao");

    }
}
