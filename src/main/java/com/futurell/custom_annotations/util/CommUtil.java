package com.futurell.custom_annotations.util;

import com.futurell.custom_annotations.annotation.Entity;
import com.futurell.custom_annotations.entity.CityEntity;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 15:37
 * @version: 1.0
 * @modified By:
 */
public class CommUtil {

    /**
     * 通过一个对象构建一条查询的SQL语句
     * @param object
     */
    public static String buildQuerySqlForEntity(CityEntity object) {
        // 得到类对象
        Class clazz = object.getClass();
        // 判断是否加了注解 ===> 打印结果为false
        // 因为自定义注解有生命周期,默认情况下只存在于源码当中,当Java虚拟机把它编译成字节码时,会自动丢失
        // 需要在Entity加一个注解 @Retention(RetentionPolicy.RUNTIME),这时候在执行的时候才会被找到
        if (clazz.isAnnotationPresent(Entity.class)) {
            // 得到注解的值
            Entity entity = (Entity) clazz.getAnnotation(Entity.class);
            // 调用方法
            String entityName = entity.value();
            // 输出: city
            System.out.println(entityName);
            // SELECT * FROM city WHERE id = '1' AND name = 'test';
            String sql = "SELECT * FROM " + entityName + " WHERE id = " + object.getId() + " AND name = " + object.getName();
            return sql;
        } else {
            return "";
        }

    }
}
