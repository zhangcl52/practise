package com.hunter.study.exception;/** * @Author zhangcl * @Date 17/2/10  下午3:36 */public class ExceptionDemo {    public static void main(String[] args){        NullPointerException nullPointerException=new NullPointerException("111111");        System.out.println(nullPointerException.getMessage());        UnCheckExceptionDemo unCheckExceptionDemo =new UnCheckExceptionDemo();        //1、方法中抛出异常了，但是这里不用try-catch也ok        unCheckExceptionDemo.doNullPointerException();        //2、必须得有try-catch才行，否则编译不过        try{            unCheckExceptionDemo.doIOException();        }catch (Exception e){        }    }}