package com.snail.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "mr_price", autoResultMap = true)
public class Price extends BaseEntity{

    private String model;

    private String type;

    private String level;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
