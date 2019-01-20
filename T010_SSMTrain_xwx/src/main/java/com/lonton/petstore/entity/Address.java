package com.lonton.petstore.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    private Integer id;
    private Integer uid;
    private String recvName;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private String recvPhone;
    private String recvTel;
    private String recvZipCode;
    private String recvTag;
    private Integer isDefault;
    private Date createdTime;
    
    public Address() {
        super();
    }
    
    public Address(Integer id, Integer uid, String recvName, String recvProvince,
                   String recvCity, String recvArea, String recvAddress, String recvPhone,
                   String recvTel, String recvZipCode, String recvTag, Integer isDefault, Date createdTime) {
        this.id = id;
        this.uid = uid;
        this.recvName = recvName;
        this.recvProvince = recvProvince;
        this.recvCity = recvCity;
        this.recvArea = recvArea;
        this.recvAddress = recvAddress;
        this.recvPhone = recvPhone;
        this.recvTel = recvTel;
        this.recvZipCode = recvZipCode;
        this.recvTag = recvTag;
        this.isDefault = isDefault;
        this.createdTime = createdTime;
    }
}