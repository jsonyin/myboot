package com.iny.proxy;

/**
 * Created by zcy on 2017/12/27.
 */
public class FourCar implements SimpleCar {
    @Override
    public String run() {
        return "开始跑步";
    }

    @Override
    public String addEnerage(int oil) {
        return "加油完毕";
    }

    @Override
    public String loudpeaker(String s) {
        return "鸣喇叭";
    }
}
