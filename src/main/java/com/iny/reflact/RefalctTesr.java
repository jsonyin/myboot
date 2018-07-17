package com.iny.reflact;

import com.iny.Proson;

import java.lang.reflect.Field;

/**
 * Created by zcy on 2018/1/29.
 */
public class RefalctTesr {

    public static void main(String args[]) throws NoSuchFieldException {

        Proson p = new Proson();
        p.setDesc("dxo ddd");
        p.setName("殷全鹏");

        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);


    }
}
