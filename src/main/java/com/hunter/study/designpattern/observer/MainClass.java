package com.hunter.study.designpattern.observer;

/**
 * Created by zhangcl
 * Data: 2018/5/10  11:50
 * version 1.0
 */
public class MainClass {
    public static void main(String[] args) {
        WechatAccount w1 = new WechatAccount("张三");
        WechatAccount w2 = new WechatAccount("李四");
        WechatAccount w3 = new WechatAccount("王五");
        PublicAccount publicAccount = new PublicAccount();
        publicAccount.registerObserver(w1);
        publicAccount.registerObserver(w2);
        publicAccount.registerObserver(w3);
        publicAccount.setMessage("我发布了新消息");
        publicAccount.removeObserver(w1);
        publicAccount.setMessage("我发布了新消息");
    }
}
