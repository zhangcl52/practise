package com.hunter.study.javabase.map;import java.util.HashMap;import java.util.Map;/** * @Author zhangcl * @Date 17/2/23  上午8:22 */public class MapDemo {    public static void main(String[] args) {        MapDemo mapDemo = new MapDemo();        mapDemo.method1();    }    /**     * 测试map中能不能放null     * 结论     * 1、map中能放null     * 2、map在put时会返回上一个为key的值     */    public void method1() {        Map map=new HashMap();        map.put(null,"1");        map.put(null,"2");        System.out.println(map.put(null,"3"));        System.out.println(map.get(null));        map.put("key","value1");        System.out.println(map.put("key","value2"));        System.out.println(map.put("key1","value2"));    }}