package com.yueqian.epidemic.beans;

public class AjaxResponseInfo<T>{
    // -1，参数不足；
    // 2，权限不足；
    // 0，正常····
    private int code;//应答状态
    private  String msg;//消息
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
