package com.futurell.custom.dao;

/**
 * @description: 实现类
 * @author: Mr.Li
 * @date: Created in 2020/7/1 15:43
 * @version: 1.0
 * @modified By:
 */
public class FutureDaoImpl implements FutureDao {

    @Override
    public void query(){
        System.out.println("FutureLL");

    }

    @Override
    public String returnString() {
        return "Return String";
    }
}
