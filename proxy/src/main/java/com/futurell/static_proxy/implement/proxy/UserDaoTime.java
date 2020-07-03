package com.futurell.static_proxy.implement.proxy;

import com.futurell.static_proxy.implement.dao.UserDao;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/1 12:34
 * @version: 1.0
 * @modified By:
 */
public class UserDaoTime implements UserDao {

    UserDao dao;

    public UserDaoTime(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void query() {
        System.out.println("---- Time ----");
        dao.query();
    }
}
