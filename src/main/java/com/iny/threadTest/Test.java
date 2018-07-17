package com.iny.threadTest;

/**
 * Created by zcy on 2018/3/6.
 */
public class Test {

    public static  boolean ready;
    public static  int number;

    public static class ReadThread extends Thread{
        public void run(){
            while(!ready){
                System.out.print(number);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String args[])throws  Exception{

        Thread t1 = new ReadThread();
        t1.start();
        Thread.sleep(10000);
        number=40;
        //ready=true;
    }


    public int[] jiandanSort(int[] array){

        for (int i =0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                int temp=0;
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

        return array;
    }

    public int[] maopaoSort(int[] array){

        for (int i=0;i<=array.length-1;i++){

            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j] ){
                    int temp;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }
        return array;
    }
}
