package com.iny.threadTest;

/**
 * Created by zcy on 2018/3/6.
 */
public class Customer implements Runnable{

    private String name;

    private Food food;

    public Customer(String name, Food food) {
        this.name = name;
        this.food = food;
    }

    @Override
    public void run() {
        if(food.count>0){
            buy();
        }else {
            boolean f=buy();
            while(!f){
                synchronized (food){
                    try {
                        System.out.println("没货了");
                        food.notifyAll();
                        food.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                f=buy();
            }
        }
    }

    public boolean buy(){
        if(food.count>0){
            food.pop(name);
            return true;
        }
        return false;
    }
}
