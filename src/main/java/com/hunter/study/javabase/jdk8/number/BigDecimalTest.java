package com.hunter.study.javabase.jdk8.number;import java.math.BigDecimal;/** * @Author 水木 * @Date 2019-07-30  20:59 */public class BigDecimalTest {    public static void main(String[] args) {        BigDecimal b1 = new BigDecimal("0.12");        BigDecimal b2 = new BigDecimal(0.12);        System.out.println(b1.add(new BigDecimal("1")));        System.out.println(b2.add(new BigDecimal("1")));    }}