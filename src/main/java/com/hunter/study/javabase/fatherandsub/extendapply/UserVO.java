package com.hunter.study.javabase.fatherandsub.extendapply;/** * @Author zhangcl * @Date 17/2/5  上午10:40 */public class UserVO {    private int age;    private String name;    UserVO(String name,int age){        this.age=age;        this.name=name;    }    public int getAge() {        return age;    }    public void setAge(int age) {        this.age = age;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }}