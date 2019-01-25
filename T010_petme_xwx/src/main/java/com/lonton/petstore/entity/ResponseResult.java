package com.lonton.petstore.entity;

/**
 *
 * @author 许万兴
 */
public class ResponseResult<T> {
    
    private int    status = 600;
    private String msg;
    private T      data;
    
    public ResponseResult() {
        super();
    }
    
    public ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public ResponseResult(T data) {
        this.data = data;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public T getData() {
        return this.data;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ResponseResult)) return false;
        final ResponseResult<?> other = (ResponseResult<?>) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getStatus() != other.getStatus()) return false;
        final Object this$msg = this.getMsg();
        final Object other$msg = other.getMsg();
        if (this$msg == null ? other$msg != null : !this$msg.equals(other$msg)) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        return true;
    }
    
    protected boolean canEqual(final Object other) {
        return other instanceof ResponseResult;
    }
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getStatus();
        final Object $msg = this.getMsg();
        result = result * PRIME + ($msg == null ? 43 : $msg.hashCode());
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        return result;
    }
    
    public String toString() {
        return "ResponseResult(status=" + this.getStatus() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}
