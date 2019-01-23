package com.lonton.petstore.entity;

import java.math.BigDecimal;
import java.util.Date;

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
    
    public String getName() {
        return this.name;
    }
    
    public String getFamily() {
        return this.family;
    }
    
    public String getSize() {
        return this.size;
    }
    
    public String getFnFeature() {
        return this.fnFeature;
    }
    
    public String getAdvantages() {
        return this.advantages;
    }
    
    public Date getBirth() {
        return this.birth;
    }
    
    public Integer getLove() {
        return this.love;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String getVariety() {
        return this.variety;
    }
    
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public String getImage() {
        return this.image;
    }
    
    public Integer getNum() {
        return this.num;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public Integer getPriority() {
        return this.priority;
    }
    
    public Integer getCreatedUser() {
        return this.createdUser;
    }
    
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setFamily(String family) {
        this.family = family;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public void setFnFeature(String fnFeature) {
        this.fnFeature = fnFeature;
    }
    
    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    
    public void setLove(Integer love) {
        this.love = love;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setVariety(String variety) {
        this.variety = variety;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Pet)) return false;
        final Pet other = (Pet) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$family = this.getFamily();
        final Object other$family = other.getFamily();
        if (this$family == null ? other$family != null : !this$family.equals(other$family)) return false;
        final Object this$size = this.getSize();
        final Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) return false;
        final Object this$fnFeature = this.getFnFeature();
        final Object other$fnFeature = other.getFnFeature();
        if (this$fnFeature == null ? other$fnFeature != null : !this$fnFeature.equals(other$fnFeature)) return false;
        final Object this$advantages = this.getAdvantages();
        final Object other$advantages = other.getAdvantages();
        if (this$advantages == null ? other$advantages != null : !this$advantages.equals(other$advantages))
            return false;
        final Object this$birth = this.getBirth();
        final Object other$birth = other.getBirth();
        if (this$birth == null ? other$birth != null : !this$birth.equals(other$birth)) return false;
        final Object this$love = this.getLove();
        final Object other$love = other.getLove();
        if (this$love == null ? other$love != null : !this$love.equals(other$love)) return false;
        final Object this$color = this.getColor();
        final Object other$color = other.getColor();
        if (this$color == null ? other$color != null : !this$color.equals(other$color)) return false;
        final Object this$variety = this.getVariety();
        final Object other$variety = other.getVariety();
        if (this$variety == null ? other$variety != null : !this$variety.equals(other$variety)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        final Object this$num = this.getNum();
        final Object other$num = other.getNum();
        if (this$num == null ? other$num != null : !this$num.equals(other$num)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) return false;
        final Object this$createdUser = this.getCreatedUser();
        final Object other$createdUser = other.getCreatedUser();
        if (this$createdUser == null ? other$createdUser != null : !this$createdUser.equals(other$createdUser))
            return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        return true;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof Pet;
    }
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $family = this.getFamily();
        result = result * PRIME + ($family == null ? 43 : $family.hashCode());
        final Object $size = this.getSize();
        result = result * PRIME + ($size == null ? 43 : $size.hashCode());
        final Object $fnFeature = this.getFnFeature();
        result = result * PRIME + ($fnFeature == null ? 43 : $fnFeature.hashCode());
        final Object $advantages = this.getAdvantages();
        result = result * PRIME + ($advantages == null ? 43 : $advantages.hashCode());
        final Object $birth = this.getBirth();
        result = result * PRIME + ($birth == null ? 43 : $birth.hashCode());
        final Object $love = this.getLove();
        result = result * PRIME + ($love == null ? 43 : $love.hashCode());
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        final Object $variety = this.getVariety();
        result = result * PRIME + ($variety == null ? 43 : $variety.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        final Object $num = this.getNum();
        result = result * PRIME + ($num == null ? 43 : $num.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $priority = this.getPriority();
        result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
        final Object $createdUser = this.getCreatedUser();
        result = result * PRIME + ($createdUser == null ? 43 : $createdUser.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        return result;
    }
    
    public String toString() {
        return "Pet(id=" + this.getId() + ", name=" + this.getName() + ", family=" + this.getFamily() + ", size=" + this.getSize() + ", fnFeature=" + this.getFnFeature() + ", advantages=" + this.getAdvantages() + ", birth=" + this.getBirth() + ", love=" + this.getLove() + ", color=" + this.getColor() + ", variety=" + this.getVariety() + ", price=" + this.getPrice() + ", image=" + this.getImage() + ", num=" + this.getNum() + ", status=" + this.getStatus() + ", priority=" + this.getPriority() + ", createdUser=" + this.getCreatedUser() + ", createdTime=" + this.getCreatedTime() + ")";
    }
}