package com.hunter.study.thread.threadlocal;/** * @Author zhangcl * @Date 17/10/26  下午10:15 */public class ThreadLocalDemo extends Thread {    public static UserManager userManager;    public ThreadLocalDemo(UserManager userManager) {        this.userManager = userManager;    }    public static void main(String[] args) {        UserManager userManager = new UserManager();        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo(userManager);        for (int i = 0; i < 6; i++) {            Thread t = new Thread(threadLocalDemo);            t.start();        }    }    public void run() {        userManager.set(new UserDemo());        userManager.setName(Thread.currentThread().getName());        System.out.println(Thread.currentThread() + " | "                + userManager.get() + " | "                + userManager.getName());    }}