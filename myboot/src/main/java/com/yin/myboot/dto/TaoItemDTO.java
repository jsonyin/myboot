package com.yin.myboot.dto;

import com.yin.myboot.model.TaoItem;

import java.util.List;

/**
 * Created by zcy on 2017/12/18.
 */
public class TaoItemDTO extends TaoItem{

    private List<String> picUrl ;

    public List<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<String> picUrl) {
        this.picUrl = picUrl;
    }
}
