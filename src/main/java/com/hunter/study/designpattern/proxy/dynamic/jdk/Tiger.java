package com.hunter.study.designpattern.proxy.dynamic.jdk;

/**
 * Created by zhangcl
 * Data: 2018/4/11  8:53
 * version 1.0
 */
public class Tiger implements AnimalInterface {
    @Override
    public void eat() {
        System.out.println("tiger is eating");
    }
}
