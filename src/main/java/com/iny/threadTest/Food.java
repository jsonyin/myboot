package com.iny.threadTest;

/**
 * Created by zcy on 2018/3/6.
 */
public class Food {

    public volatile int count;

    public Food(int  count) {
        this.count = count;
    }

    public void push(String name){
        count++;
        System.out.println(name+"生产了一个汉堡,还有"+count+"个");
    }

    public void pop(String name){
        count--;
        System.out.println(name+"购买了一个汉堡,还有"+count+"个");
    }
}
