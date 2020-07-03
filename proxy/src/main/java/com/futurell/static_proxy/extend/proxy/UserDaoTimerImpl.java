package com.futurell.static_proxy.extend.proxy;

import com.futurell.static_proxy.extend.dao.UserDaoImpl;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/1 12:28
 * @version: 1.0
 * @modified By:
 */
public class UserDaoTimerImpl extends UserDaoImpl {

    @Override
    public void query() {
        System.out.println("---- time ----");
        super.query();
    }
}
