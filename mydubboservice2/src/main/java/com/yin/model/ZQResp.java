package com.yin.model;

import java.io.Serializable;

/**
 * Created by zcy on 2018/3/16.
 */
public class ZQResp<T> implements Serializable {
    private boolean status;

    private String message;

    private T data;

    public ZQResp(T data){
        this.status=true;
        this.data=data;
    }

    public ZQResp(boolean status,String message){
        this.status=status;
        this.message=message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
