package com.iny;

import java.util.List;

/**
 * Created by zcy on 2017/11/10.
 */
public class Proson {

    private String name;
    private String desc;
    private List<String> familyMember;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(List<String> familyMember) {
        this.familyMember = familyMember;
    }
}
