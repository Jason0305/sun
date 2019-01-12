package com.lonton.petstore.entity;

public class Cart {
    private Integer id;

    private Integer uid;

    private Long petId;

    private Integer petNum;

    public Cart(Integer id, Integer uid, Long petId, Integer petNum) {
        this.id = id;
        this.uid = uid;
        this.petId = petId;
        this.petNum = petNum;
    }

    public Cart() {
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

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Integer getPetNum() {
        return petNum;
    }

    public void setPetNum(Integer petNum) {
        this.petNum = petNum;
    }
}