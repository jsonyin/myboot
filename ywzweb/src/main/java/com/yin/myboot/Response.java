package com.yin.myboot;

/**
 * Created by zcy on 2017/12/13.
 */
public class Response<T> {

    private boolean status;
    private T date;

    public Response(boolean status,T date){
        this.status=status;
        this.date=date;
    }

    public Response(boolean status){
        this.status=status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
