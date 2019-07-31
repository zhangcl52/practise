package com.hunter.study.javabase.jdk8.inte;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangcl
 * Data: 2018/7/17  12:27
 * version 1.0
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream().filter(n -> (
                n == 3)
        ).collect(Collectors.toList());
        list.stream().forEach(n -> System.out.println(n));
    }
}
