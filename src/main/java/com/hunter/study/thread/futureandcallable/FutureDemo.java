package com.hunter.study.thread.futureandcallable;import java.util.concurrent.*;/** * @Author zhangcl * @Date 17/2/11  下午12:15 */public class FutureDemo {    public static void main(String[] args) {        ExecutorService executorService = Executors.newCachedThreadPool();        Task task = new Task();        Future<Integer> future = executorService.submit(task);        executorService.shutdown();        try {            Thread.sleep(1000);        } catch (InterruptedException e1) {            e1.printStackTrace();        }        try {            System.out.println("task运行结果" + future.get());        } catch (InterruptedException e) {            e.printStackTrace();        } catch (ExecutionException e) {            e.printStackTrace();        }        System.out.println("所有任务执行完毕");    }}class Task implements Callable {    @Override    public Object call() throws Exception {        System.out.println("子线程正在计算");        int count = 0;        for (int i = 0; i < 100; i++)            count = count + i;        System.out.println("子线程计算完成");        return count;    }}