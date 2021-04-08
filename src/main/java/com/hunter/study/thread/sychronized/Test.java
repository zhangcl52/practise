package com.hunter.study.thread.sychronized;import java.util.Arrays;import java.util.List;/** * @Author 水木 * @Date 2021/2/25  9:14 上午 */public class Test {	private static final Object LOCK = new Object();	public static void main(String[] args) throws InterruptedException {		int n = 10;		Thread[] threads = new Thread[n];		for (int i = 0; i < n; ++i) {			threads[i] = new Thread(() -> {				System.out.println(Thread.currentThread().getName() + " 线程状态是 ==》" + Thread.currentThread().getState().name());				synchronized (LOCK) {					System.out.println(Thread.currentThread().getName() + " get lock");				}			}, String.valueOf(i));		}		synchronized (LOCK) {			for (int i = 0; i < n; ++i) {				threads[i].start();//				Thread.sleep(10);				LOCK.wait(10);				System.out.println(threads[i].getName() + " 线程状态是 ==》" + threads[i].getState().name());			}		}		final List<Integer> integers = Arrays.asList(1, 2);	}}