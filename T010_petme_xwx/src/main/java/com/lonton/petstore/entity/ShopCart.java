package com.lonton.petstore.entity;

public class ShopCart {
    private Integer id;

    private Integer uid;

    private Integer petId;

    private Integer petNum;

    public ShopCart(Integer id, Integer uid, Integer petId, Integer petNum) {
        this.id = id;
        this.uid = uid;
        this.petId = petId;
        this.petNum = petNum;
    }

    public ShopCart() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getPetNum() {
        return petNum;
    }

    public void setPetNum(Integer petNum) {
        this.petNum = petNum;
    }
}