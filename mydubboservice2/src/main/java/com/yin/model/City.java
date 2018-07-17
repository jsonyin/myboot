package com.yin.model;

import java.io.Serializable;

/**
 * Created by zcy on 2018/1/19.
 */
public class City implements Serializable {

    private String cityCode;
    private String cityName;

    public City(String cityCode,String cityName){
        this.cityCode=cityCode;
        this.cityName=cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
