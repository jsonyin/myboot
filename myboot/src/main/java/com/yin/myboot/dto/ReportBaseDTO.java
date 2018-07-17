package com.yin.myboot.dto;

import java.util.Map;

/**
 * Created by zcy on 2018/7/13.
 */
public class ReportBaseDTO<T> {

    private String key;

    private Map<String,T> valueMap;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, T> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<String, T> valueMap) {
        this.valueMap = valueMap;
    }
}
