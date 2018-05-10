package com.hunter.study.designpattern.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zhangcl
 * Data: 2018/5/10  11:34
 * version 1.0
 */
public class PublicAccount implements Observerable {
    private List<Observer> observerList = Lists.newArrayList();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer observer : observerList) {
            observer.update(msg);
        }
    }

    public void setMessage(String message) {
        notifyObserver(message);
    }
}
