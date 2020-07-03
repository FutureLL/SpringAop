package com.futurell.dao;

import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 18:19
 * @version: 1.0
 * @modified By:
 */
@Repository
public class IndexDao implements Dao {

    public void query(String str) {
        System.out.println(str);
    }
}
