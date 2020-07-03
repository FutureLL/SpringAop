package com.futurell.custom.dao;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/7/1 10:55
 * @version: 1.0
 * @modified By:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void query(){
        System.out.println("假装查询数据库");
    }

    @Override
    public void query(String str){
        System.out.println(str);
    }
}
