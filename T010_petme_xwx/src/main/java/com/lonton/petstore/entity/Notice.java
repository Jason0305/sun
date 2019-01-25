package com.lonton.petstore.entity;

import java.util.Date;

public class Notice {
    private Integer id;
    private String title;
    private Integer createdUser;
    private Date createdTime;
    private String content;
    
    public Notice() {
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public Integer getCreatedUser() {
        return this.createdUser;
    }
    
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Notice)) return false;
        final Notice other = (Notice) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$createdUser = this.getCreatedUser();
        final Object other$createdUser = other.getCreatedUser();
        if (this$createdUser == null ? other$createdUser != null : !this$createdUser.equals(other$createdUser))
            return false;
        final Object this$createdTime = this.getCreatedTime();
        final Object other$createdTime = other.getCreatedTime();
        if (this$createdTime == null ? other$createdTime != null : !this$createdTime.equals(other$createdTime))
            return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        return true;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof Notice;
    }
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $createdUser = this.getCreatedUser();
        result = result * PRIME + ($createdUser == null ? 43 : $createdUser.hashCode());
        final Object $createdTime = this.getCreatedTime();
        result = result * PRIME + ($createdTime == null ? 43 : $createdTime.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        return result;
    }
    
    public String toString() {
        return "Notice(id=" + this.getId() + ", title=" + this.getTitle() + ", createdUser=" + this.getCreatedUser() + ", createdTime=" + this.getCreatedTime() + ", content=" + this.getContent() + ")";
    }
}