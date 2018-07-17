package com.iny.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zcy on 2018/1/6.
 */
public class ThreadPoolTest {

        public static void main(String args[]){
            long s = System.currentTimeMillis();
            ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
            for(int i = 1;i<10;i++){
                threadPool.execute(new MyThread(i));
            }

            threadPool.shutdown();

            long e = System.currentTimeMillis();
            System.out.println();
            System.out.println("花费"+(e-s)+"时间");
        }

}

class MyThread implements Runnable{

    int count;

    public MyThread(int count){
        this.count = count;
    }

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName());
        System.out.println("这是第"+count+"个线程");
    }
}
