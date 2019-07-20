package com.hunter.study.javabase.jdk8;import com.google.common.collect.Lists;import java.util.List;/** * @Author 水木 * @Date 2019-07-20  14:34 */public class ReduceDemo {    public static void main(String[] args) {        //reduce应用在多个值，进行计算后变成一个的场景中。比如求和，最大值，最小值等        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);        Integer sum = list.stream().reduce((x, y) -> x + y).get();        Integer sum1 = list.stream().reduce(1, Integer::sum);        System.out.println(sum);        System.out.println(sum1);    }}