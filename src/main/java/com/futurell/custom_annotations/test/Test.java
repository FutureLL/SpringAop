package com.futurell.custom_annotations.test;

import com.futurell.custom_annotations.entity.CityEntity;
import com.futurell.custom_annotations.util.CommUtil;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 15:37
 * @version: 1.0
 * @modified By:
 */
public class Test {

    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        String sql = CommUtil.buildQuerySqlForEntity(cityEntity);
        // SELECT * FROM city WHERE id = '1' AND name = 'test';
        System.out.println(sql);
    }
}
