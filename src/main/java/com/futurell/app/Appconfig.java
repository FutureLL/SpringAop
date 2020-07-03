package com.futurell.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 18:14
 * @version: 1.0
 * @modified By:
 */

@ComponentScan("com.futurell")
@Configuration
/**
 * CGLIB代理继承(extends)目标对象,JDK动态代理实现(implements)目标对象
 * 默认为false(JDK动态代理)
 * 为true时,使用CGLIB代理,此时代理对象和目标对象相等,也就是 dao instanceof IndexDao 为true
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {

}
