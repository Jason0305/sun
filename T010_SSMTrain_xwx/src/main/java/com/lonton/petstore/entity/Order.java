package com.lonton.petstore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Integer uid;

    private String recvName;

    private String recvPhone;

    private String recvAddress;

    private BigDecimal totalPrice;

    private Integer status;

    private Date createdTime;

    private Date payTime;

    public Order(Integer id, Integer uid, String recvName, String recvPhone, String recvAddress, BigDecimal totalPrice, Integer status, Date createdTime, Date payTime) {
        this.id = id;
        this.uid = uid;
        this.recvName = recvName;
        this.recvPhone = recvPhone;
        this.recvAddress = recvAddress;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdTime = createdTime;
        this.payTime = payTime;
    }

    public Order() {
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

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName == null ? null : recvName.trim();
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone == null ? null : recvPhone.trim();
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress == null ? null : recvAddress.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}