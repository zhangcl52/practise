package com.hunter.study.javabase.jdk8;import java.util.Collections;import java.util.List;import java.util.Optional;/** * @Author 水木 * @Date 2019-07-20  16:37 */public class OptionalDemo {    public static void main(String[] args) {        List<Integer> list = null;        //可以屏蔽掉是null的情况//        System.out.println(Optional.ofNullable(list).map(List::size).orElse(0));        System.out.println(Optional.ofNullable(list)                .orElse(Collections.emptyList())                .stream()                .reduce(-1, (x, y) -> x + x));    }}