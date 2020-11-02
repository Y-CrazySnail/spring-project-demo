package com.snail.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "role", autoResultMap = true)
public class Role extends BaseEntity{
    /**
     * 名称
     */
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}