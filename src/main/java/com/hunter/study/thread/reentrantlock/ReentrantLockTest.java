package com.hunter.study.thread.reentrantlock;import java.util.concurrent.locks.ReentrantLock;/** * @Author 水木 * @Date 2020/7/17  1:06 下午 */public class ReentrantLockTest {    public static void main(String[] args) {        final ReentrantTest test = new ReentrantTest();        for (int i = 0; i < 10; i++) {            new Thread(() -> {                test.M1();            }, i + "").start();        }    }}class ReentrantTest {    ReentrantLock lock = new ReentrantLock();    public void M1() {        System.out.println(String.format("第%s个线程---等待锁", Thread.currentThread().getName()));        lock.lock();        System.out.println(String.format("第%s个线程---获取锁", Thread.currentThread().getName()));        try {            Thread.sleep(2);        } catch (InterruptedException e) {            e.printStackTrace();        } finally {            lock.unlock();        }        System.out.println(String.format("第%s个线程---释放锁", Thread.currentThread().getName()));    }}