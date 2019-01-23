package com.lonton.petstore.entity;

public class District {
    private Integer id;
    private String parent;
    private String code;
    private String name;
    
    public District() {
    }
    
    public District(Integer id, String parent, String code, String name) {
        this.id = id;
        this.parent = parent;
        this.code = code;
        this.name = name;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public String getParent() {
        return this.parent;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setParent(String parent) {
        this.parent = parent;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof District)) return false;
        final District other = (District) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$parent = this.getParent();
        final Object other$parent = other.getParent();
        if (this$parent == null ? other$parent != null : !this$parent.equals(other$parent)) return false;
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof District;
    }
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $parent = this.getParent();
        result = result * PRIME + ($parent == null ? 43 : $parent.hashCode());
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }
    
    public String toString() {
        return "District(id=" + this.getId() + ", parent=" + this.getParent() + ", code=" + this.getCode() + ", name=" + this.getName() + ")";
    }
}