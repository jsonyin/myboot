package com.iny.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zcy on 2018/1/31.
 */
public class LockTest {
    public static void main(String args[]){
        Ticket t1 = new Ticket();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        pool.execute(t1);
        pool.execute(t1);
        pool.execute(t1);
        pool.execute(t1);
        pool.execute(t1);
        pool.execute(t1);
    }
}



class Ticket implements Runnable{

    private int tickets=100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {

                lock.lock();
                if(tickets>0){
                    System.out.println(Thread.currentThread().getName()+"正在买第"+tickets);
                    Thread.sleep(100);
                    tickets--;
                }
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }

    }
}
