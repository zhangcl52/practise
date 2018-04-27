package com.hunter.study.designpattern.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by zhangcl
 * Data: 2018/4/11  9:51
 * version 1.0
 */

public class Main {
    public static void main(String[] args) {
        //创建委拖类
        AnimalInterface tiger = new Tiger();
        //增加统一处理逻辑的类
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(tiger);
        //代理类
        AnimalInterface myProxy = (AnimalInterface) myInvocationHandler.getProxy();
        myProxy.eat();

        //调用过程    代理类->自定义逻辑增强处理类->委托类
        //1、代理类调用逻辑处理类的invoke方法，参数为自己，调用的方法，参数
        //2、自己实现的逻辑处理类处理逻辑后，利用反射调用委托类
        //3、委托类实现已有逻辑
    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{AnimalInterface.class});
        try {
            FileOutputStream out = new FileOutputStream(name + ".class");
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
