package com.hunter.study.designpattern.observer;

/**
 * Created by zhangcl
 * Data: 2018/5/10  11:18
 * version 1.0
 */
public interface Observerable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String msg);
}
