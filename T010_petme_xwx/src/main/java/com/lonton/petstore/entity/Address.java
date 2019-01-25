package com.lonton.petstore.entity;

import java.util.Date;

public class Address {
    private Integer id;
    private Integer uid;
    private String recvName;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvDistrict;
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
    
    public Integer getId() {
        return this.id;
    }
    
    public Integer getUid() {
        return this.uid;
    }
    
    public String getRecvName() {
        return this.recvName;
    }
    
    public String getRecvProvince() {
        return this.recvProvince;
    }
    
    public String getRecvCity() {
        return this.recvCity;
    }
    
    public String getRecvArea() {
        return this.recvArea;
    }
    
    public String getRecvDistrict() {
        return this.recvDistrict;
    }
    
    public String getRecvAddress() {
        return this.recvAddress;
    }
    
    public String getRecvPhone() {
        return this.recvPhone;
    }
    
    public String getRecvTel() {
        return this.recvTel;
    }
    
    public String getRecvZipCode() {
        return this.recvZipCode;
    }
    
    public String getRecvTag() {
        return this.recvTag;
    }
    
    public Integer getIsDefault() {
        return this.isDefault;
    }
    
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }
    
    public void setRecvProvince(String recvProvince) {
        this.recvProvince = recvProvince;
    }
    
    public void setRecvCity(String recvCity) {
        this.recvCity = recvCity;
    }
    
    public void setRecvArea(String recvArea) {
        this.recvArea = recvArea;
    }
    
    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict;
    }
    
    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }
    
    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }
    
    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel;
    }
    
    public void setRecvZipCode(String recvZipCode) {
        this.recvZipCode = recvZipCode;
    }
    
    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag;
    }
    
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Address)) return false;
        final Address other = (Address) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$uid = this.getUid();
        final Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) return false;
        final Object this$recvName = this.getRecvName();
        final Object other$recvName = other.getRecvName();
        if (this$recvName == null ? other$recvName != null : !this$recvName.equals(other$recvName)) return false;
        final Object this$recvProvince = this.getRecvProvince();
        final Object other$recvProvince = other.getRecvProvince();
        if (this$recvProvince == null ? other$recvProvince != null : !this$recvProvince.equals(other$recvProvince))
            return false;
        final Object this$recvCity = this.getRecvCity();
        final Object other$recvCity = other.getRecvCity();
        if (this$recvCity == null ? other$recvCity != null : !this$recvCity.equals(other$recvCity)) return false;
        final Object this$recvArea = this.getRecvArea();
        final Object other$recvArea = other.getRecvArea();
        if (this$recvArea == null ? other$recvArea != null : !this$recvArea.equals(other$recvArea)) return false;
        final Object this$recvDistrict = this.getRecvDistrict();
        final Object other$recvDistrict = other.getRecvDistrict();
        if (this$recvDistrict == null ? other$recvDistrict != null : !this$recvDistrict.equals(other$recvDistrict))
            return false;
        final Object this$recvAddress = this.getRecvAddress();
        final Object other$recvAddress = other.getRecvAddress();
        if (this$recvAddress == null ? other$recvAddress != null : !this$recvAddress.equals(other$recvAddress))
            return false;
        final Object this$recvPhone = this.getRecvPhone();
        final Object other$recvPhone = other.getRecvPhone();
        if (this$recvPhone == null ? other$recvPhone != null : !this$recvPhone.equals(other$recvPhone)) return false;
        final Object this$recvTel = this.getRecvTel();
        final Object other$recvTel = other.getRecvTel();
        if (this$recvTel == null ? other$recvTel != null : !this$recvTel.equals(other$recvTel)) return false;
        final Object this$recvZipCode = this.getRecvZipCode();
        final Object other$recvZipCode = other.getRecvZipCode();
        if (this$recvZipCode == null ? other$recvZipCode != null : !this$recvZipCode.equals(other$recvZipCode))
            return false;
        final Object this$recvTag = this.getRecvTag();
        final Object other$recvTag = other.getRecvTag();
        if (this$recvTag == null ? other$recvTag != null : !this$recvTag.equals(other$recvTag)) return false;
        final Object this$isDefault = this.getIsDefault();
        final Object other$isDefault = other.getIsDefault();
        if (this$isDefault == null ? other$isDefault != null : !this$isDefault.equals(other$isDefault)) return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        return true;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof Address;
    }
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $uid = this.getUid();
        result = result * PRIME + ($uid == null ? 43 : $uid.hashCode());
        final Object $recvName = this.getRecvName();
        result = result * PRIME + ($recvName == null ? 43 : $recvName.hashCode());
        final Object $recvProvince = this.getRecvProvince();
        result = result * PRIME + ($recvProvince == null ? 43 : $recvProvince.hashCode());
        final Object $recvCity = this.getRecvCity();
        result = result * PRIME + ($recvCity == null ? 43 : $recvCity.hashCode());
        final Object $recvArea = this.getRecvArea();
        result = result * PRIME + ($recvArea == null ? 43 : $recvArea.hashCode());
        final Object $recvDistrict = this.getRecvDistrict();
        result = result * PRIME + ($recvDistrict == null ? 43 : $recvDistrict.hashCode());
        final Object $recvAddress = this.getRecvAddress();
        result = result * PRIME + ($recvAddress == null ? 43 : $recvAddress.hashCode());
        final Object $recvPhone = this.getRecvPhone();
        result = result * PRIME + ($recvPhone == null ? 43 : $recvPhone.hashCode());
        final Object $recvTel = this.getRecvTel();
        result = result * PRIME + ($recvTel == null ? 43 : $recvTel.hashCode());
        final Object $recvZipCode = this.getRecvZipCode();
        result = result * PRIME + ($recvZipCode == null ? 43 : $recvZipCode.hashCode());
        final Object $recvTag = this.getRecvTag();
        result = result * PRIME + ($recvTag == null ? 43 : $recvTag.hashCode());
        final Object $isDefault = this.getIsDefault();
        result = result * PRIME + ($isDefault == null ? 43 : $isDefault.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        return result;
    }
    
    public String toString() {
        return "Address(id=" + this.getId() + ", uid=" + this.getUid() + ", recvName=" + this.getRecvName() + ", recvProvince=" + this.getRecvProvince() + ", recvCity=" + this.getRecvCity() + ", recvArea=" + this.getRecvArea() + ", recvDistrict=" + this.getRecvDistrict() + ", recvAddress=" + this.getRecvAddress() + ", recvPhone=" + this.getRecvPhone() + ", recvTel=" + this.getRecvTel() + ", recvZipCode=" + this.getRecvZipCode() + ", recvTag=" + this.getRecvTag() + ", isDefault=" + this.getIsDefault() + ", createdTime=" + this.getCreatedTime() + ")";
    }
}