package com.lonton.petstore.entity;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;

    private Integer orderId;

    private Integer petId;

    private String petName;

    private Integer petAge;

    private String petColor;

    private BigDecimal petPrice;

    private String petImage;

    private Integer petNum;

    public OrderItem(Integer id, Integer orderId, Integer petId, String petName, Integer petAge, String petColor, BigDecimal petPrice, String petImage, Integer petNum) {
        this.id = id;
        this.orderId = orderId;
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
        this.petColor = petColor;
        this.petPrice = petPrice;
        this.petImage = petImage;
        this.petNum = petNum;
    }

    public OrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor == null ? null : petColor.trim();
    }

    public BigDecimal getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(BigDecimal petPrice) {
        this.petPrice = petPrice;
    }

    public String getPetImage() {
        return petImage;
    }

    public void setPetImage(String petImage) {
        this.petImage = petImage == null ? null : petImage.trim();
    }

    public Integer getPetNum() {
        return petNum;
    }

    public void setPetNum(Integer petNum) {
        this.petNum = petNum;
    }
}