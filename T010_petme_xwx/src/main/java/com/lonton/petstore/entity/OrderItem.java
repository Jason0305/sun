package com.lonton.petstore.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
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
    
}