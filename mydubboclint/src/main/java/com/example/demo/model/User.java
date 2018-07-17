package com.example.demo.model;

import java.io.Serializable;

/**
 * Created by zcy on 2018/3/25.
 */
public class User implements Serializable {
    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString(){
        return "name:"+this.name+"，code:"+this.code;
    }
}
