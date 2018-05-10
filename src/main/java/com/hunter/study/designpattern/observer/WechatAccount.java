package com.hunter.study.designpattern.observer;

/**
 * Created by zhangcl
 * Data: 2018/5/10  11:47
 * version 1.0
 */
public class WechatAccount implements Observer {
    public String accountName;

    public WechatAccount(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public void update(String mes) {
        System.out.println(accountName + "收到消息" + mes);
    }
}
