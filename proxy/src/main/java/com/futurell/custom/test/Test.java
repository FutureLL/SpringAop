package com.futurell.custom.test;

import com.futurell.custom.dao.FutureDao;
import com.futurell.custom.dao.FutureDaoImpl;
import com.futurell.custom.dao.UserDao;
import com.futurell.custom.dao.UserDaoImpl;
import com.futurell.custom.proxy.ProxyUtil;

/**
 * @description: 测试
 * @author: Mr.Li
 * @date: Created in 2020/7/1 10:56
 * @version: 1.0
 * @modified By:
 */
public class Test {

    public static void main(String[] args) {
        UserDao proxy = (UserDao) ProxyUtil.newInstance(new UserDaoImpl());
        proxy.query("我是谁");

        System.out.println("------------------");

        FutureDao fProxy = (FutureDao) ProxyUtil.newInstance(new FutureDaoImpl());
        fProxy.query();

        System.out.println("------------------");

        FutureDao fProxyString = (FutureDao) ProxyUtil.newInstance(new FutureDaoImpl());
        System.out.println(fProxyString.returnString());

    }
}
