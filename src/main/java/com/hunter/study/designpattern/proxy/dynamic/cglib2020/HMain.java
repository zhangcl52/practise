package com.hunter.study.designpattern.proxy.dynamic.cglib2020;/** * @Author 水木 * @Date 2020/3/3  10:12 上午 */public class HMain {    public static void main(String[] args) {        HTiger hTiger = new HTiger();        HMethodInterceptor hMethodInterceptor = new HMethodInterceptor(hTiger);        HTiger proxyTiger = (HTiger) hMethodInterceptor.getProxy();        proxyTiger.eat();    }}