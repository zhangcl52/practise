package com.hunter.study.javabase.list;import lombok.Setter;import java.util.List;import java.util.StringJoiner;/** * @Author 水木 * @Date 2021/3/9  5:36 下午 */@Setterpublic class Person {	private Integer age;	private String name;	private List<Body> bodyList;	public Person() {	}	@Override	public String toString() {		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")				.add("age=" + age)				.add("name='" + name + "'")				.add("bodyList=" + bodyList)				.toString();	}}