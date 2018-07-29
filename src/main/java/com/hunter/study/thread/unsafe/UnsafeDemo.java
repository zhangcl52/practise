package com.hunter.study.thread.unsafe;import org.junit.Test;import sun.misc.Unsafe;import java.lang.reflect.Field;import java.util.concurrent.atomic.AtomicInteger;/** * @Author zhangcl * @Date 18/7/12  下午1:01 */public class UnsafeDemo {    /**     * 获取Unsafe类的实例     *     * @return     */    @Test    public Unsafe getInstance() {        Unsafe unsafe = null;        try {            Field field = Unsafe.class.getDeclaredField("theUnsafe");            field.setAccessible(true);            unsafe = (Unsafe) field.get(null);        } catch (Exception e) {            e.printStackTrace();        }        return unsafe;    }    /**     * 分配堆外内存     */    @Test    public void allocateMemoryTest() {        Unsafe unsafe = getInstance();        Long address = unsafe.allocateMemory(1L);        unsafe.putLong(address, 123L);        System.out.println(unsafe.getAddress(address));    }    /**     * 生成对象     */    @Test    public void allocateInstanceTest() {        //利用Unsafe类生成对象        //创建对象时，只执行静态代码块，不会执行类中的构造方法        PeopleDemo peopleDemo = null;        Unsafe unsafe = getInstance();        try {            peopleDemo = (PeopleDemo) unsafe.allocateInstance(PeopleDemo.class);            System.out.println(peopleDemo.toString());        } catch (Exception e) {            e.printStackTrace();        }        //利用反射生成对象        //创建对象时，静态代码块和构造方法都会执行        PeopleDemo peopleDemo1 = null;        try {            peopleDemo1 = (PeopleDemo) Class.forName("com.hunter.study.thread.unsafe.PeopleDemo").newInstance();            System.out.println(peopleDemo1.toString());        } catch (Exception e) {            e.printStackTrace();        }    }    /**     * 可以操作类、对象、变量     */    @Test    public void fieldOffsetTest() throws Exception {        PeopleDemo peopleDemo = new PeopleDemo();        Unsafe unsafe = getInstance();        //获取类的属性的偏移量        long address = unsafe.objectFieldOffset(PeopleDemo.class.getDeclaredField("name"));        //给属性赋值        unsafe.putObject(peopleDemo, address, "一闪一闪亮晶晶");        System.out.println(peopleDemo.getName());    }    /**     * cas为Java的锁机制提供了一种新的解决办法，比如AtomicInteger等类都是通过该方法来实现的。     * compareAndSwap方法是原子的，可以避免繁重的锁机制，提高代码效率。     * 这是一种乐观锁，通常认为在大部分情况下不出现竞态条件，如果操作失败，会不断重试直到成功     */    @Test    public void casTest() {        AtomicInteger atomicInteger = new AtomicInteger(0);        for (int i = 0; i < 10; i++) {            new Thread(new Runnable() {                @Override                public void run() {                    atomicInteger.getAndIncrement();                    System.out.println(atomicInteger.get());                }            }).start();        }    }    /**     * 不使用AtomicInteger时     */    @Test    public void casTest1() {        Runnable runnable = new Runnable() {            private Integer integer = 0;            @Override            public void run() {                try{                    Thread.sleep(5);                }catch (Exception e){                    e.printStackTrace();                }                integer++;                System.out.println(Thread.currentThread().getName() + ":" + integer);            }        };        for (int i = 0; i < 10; i++) {            Thread thread = new Thread(runnable);            thread.start();        }    }}