package com.futurell.custom_annotations.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 15:49
 * @version: 1.0
 * @modified By:
 *
 * @Target: @Entity注解出现的位置在目标类上边
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

    public String value() default "";
}
