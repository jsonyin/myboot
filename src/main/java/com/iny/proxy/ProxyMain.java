package com.iny.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by zcy on 2017/12/27.
 */
public class ProxyMain {

    public static void main(String args[]){
//       SimpleCar car = (SimpleCar)Proxy.newProxyInstance(SimpleCar.class.getClassLoader(),new Class[]{SimpleCar.class},
//                new CarHandler(new FourCar()));

//        System.out.print(car.loudpeaker("sss"));
        CglibProxy cp = new CglibProxy();
        Carone s =(Carone) cp.getInstance(Carone.class);
        s.go();
    }
}
