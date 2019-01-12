package com.lonton.petstore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Pets {
    private Integer id;

    private String category;

    private String name;

    private Date age;

    private String color;

    private String variety;

    private BigDecimal price;

    private String image;

    private Integer num;

    private Integer status;

    private Integer priority;

    private Integer createdUser;

    private Date createdTime;

    public Pets(Integer id, String category, String name, Date age, String color, String variety, BigDecimal price, String image, Integer num, Integer status, Integer priority, Integer createdUser, Date createdTime) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.age = age;
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

    public Pets() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety == null ? null : variety.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}