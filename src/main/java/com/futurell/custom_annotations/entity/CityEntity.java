package com.futurell.custom_annotations.entity;

import com.futurell.custom_annotations.annotation.Entity;

/**
 * @description:
 * @author: Mr.Li
 * @date: Created in 2020/6/29 15:36
 * @version: 1.0
 * @modified By:
 */
@Entity(value = "city")
public class CityEntity {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
