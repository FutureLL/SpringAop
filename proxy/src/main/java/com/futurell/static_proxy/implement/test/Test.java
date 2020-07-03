package com.futurell.static_proxy.implement.test;

import com.futurell.static_proxy.implement.dao.UserDaoImpl;
import com.futurell.static_proxy.implement.dao.UserDao;
import com.futurell.static_proxy.implement.proxy.UserDaoLog;
import com.futurell.static_proxy.implement.proxy.UserDaoTime;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/1 12:36
 * @version: 1.0
 * @modified By:
 */
public class Test {

    public static void main(String[] args) {
        UserDao target = new UserDaoTime(new UserDaoImpl());
        UserDao proxy = new UserDaoLog(target);

        proxy.query();
    }
}
