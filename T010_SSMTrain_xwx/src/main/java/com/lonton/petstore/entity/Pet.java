package com.lonton.petstore.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Pet {
    private Integer id;
    private String name;
    private String family;
    private String size;
    private String fnFeature;
    private String advantages;
    private Date birth;
    private Integer love;
    private String color;
    private String variety;
    private BigDecimal price;
    private String image;
    private Integer num;
    private Integer status;
    private Integer priority;
    private Integer createdUser;
    private Date createdTime;

    public Pet(Integer id, String name, String family, String size, String fnFeature, String advantages, Date birth, Integer love, String color, String variety, BigDecimal price, String image, Integer num, Integer status, Integer priority, Integer createdUser, Date createdTime) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.size = size;
        this.fnFeature = fnFeature;
        this.advantages = advantages;
        this.birth = birth;
        this.love = love;
        this.color = color;
        this.variety = variety;
        this.price = price;
        this.image = image;
        this.num = num;
        this.status = status;
        this.priority = priority;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
    }

    public Pet() {
        super();
    }

    public Integer getId() {
        return id;
    }
    
}