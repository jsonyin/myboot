package com.iny;

/**
 * Created by zcy on 2018/4/12.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if( Singleton.instance == null ){
            synchronized (Singleton.class){
                if(Singleton.instance == null){
                    instance = new Singleton();
                    return instance;
                }
            }
        }
            return instance;
    }
}
