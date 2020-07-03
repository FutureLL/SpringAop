package com.futurell.static_proxy.extend.test;

import com.futurell.static_proxy.extend.dao.UserDaoImpl;
import com.futurell.static_proxy.extend.proxy.UserDaoLogAndTimeImpl;
import com.futurell.static_proxy.extend.proxy.UserDaoPowerImpl;
import com.futurell.static_proxy.extend.proxy.UserDaoTimerImpl;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/1 12:28
 * @version: 1.0
 * @modified By:
 *
 * 现在有三个代理对象：UserDaoLogImpl、UserDaoPowerImpl、UserDaoTimerImpl
 */
public class Test {

    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoLogAndTimeImpl();
        dao.query();
    }
}
