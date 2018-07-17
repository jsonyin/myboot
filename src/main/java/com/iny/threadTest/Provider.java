package com.iny.threadTest;

/**
 * Created by zcy on 2018/3/6.
 */
public class Provider implements Runnable {

    private String name;

    private Food food;

    public Provider(String name, Food food) {
        this.name = name;
        this.food = food;
    }


    @Override
    public void run() {
        while(true){
            if(food.count<=10){
                synchronized (food) {
                    food.push(name);
                    try {
                        food.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
            }
    }


}
