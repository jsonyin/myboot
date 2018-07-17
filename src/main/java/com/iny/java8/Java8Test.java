package com.iny.java8;

import com.iny.Proson;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by zcy on 2018/4/10.
 */
public class Java8Test {
    public static void main(String[] args) {
//        List<Proson> prosonList = new ArrayList<>();
//
//        Proson p1 = new Proson();
//        p1.setDesc("i am p1");
//
//        Proson p2 = new Proson();
//        p2.setDesc("i am p2");
//
//        Proson p3 = new Proson();
//        p3.setDesc("i am p3");
//
//        prosonList.add(p1);
//        prosonList.add(p2);
//        prosonList.add(p3);

       // prosonList.forEach(p->System.out.println(p.getDesc()));

       // eval(prosonList,p->p.contains("p"));
       // System.out.print(prosonList.stream().filter(proson -> proson.getDesc().contains("p")));

//        stream(prosonList);
        try {
            exceptiontest();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void eval(List list, Predicate<String> predicate){
        for(Object obj:list){
            Proson p = (Proson)obj;
            if(predicate.test(p.getDesc())){
                System.out.println(p);
            }
        }
    }

    public static void stream(List<Proson> list){
       List<Proson> n =  list.stream().filter(l->l.getDesc().contains("p")).collect(Collectors.toList());
        for (Proson p:n){
            System.out.println(p.getDesc());
        }
    }

    public static void exceptiontest(){
        try {
            throw new NullPointerException("这有个错误等待处理");
        }catch (NullPointerException npe){
            npe.printStackTrace();
            throw new RuntimeException(npe.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }}
