package com.futurell.static_proxy.implement.proxy;

import com.futurell.static_proxy.implement.dao.UserDao;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/1 12:34
 * @version: 1.0
 * @modified By:
 */
public class UserDaoLog implements UserDao {

    UserDao dao;

    public UserDaoLog(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void query() {
        System.out.println("---- log ----");
        dao.query();
    }
}
