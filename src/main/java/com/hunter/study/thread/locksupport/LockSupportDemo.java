package com.hunter.study.thread.locksupport;import java.util.concurrent.locks.LockSupport;/** * @Author zhangcl * @Date 18/7/10  上午8:57 */public class LockSupportDemo {    public static void main(String[] args) {        Thread t = new Thread() {            @Override            public void run() {                System.out.println("park before");                LockSupport.park(this);                System.out.println("park after");            }        };        t.start();        try{            //Thread.sleep(2000);//            System.out.println("unpark is finished");//            LockSupport.unpark(t);        }catch (Exception e){            e.printStackTrace();        }    }}