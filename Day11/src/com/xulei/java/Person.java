package com.xulei.java;

import java.sql.SQLOutput;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-12 21:32
 * @since JDK 1.8
 */
public class Person {
    private String name;
    public  int age;

    private  Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("我是一个人");
    }
    private  String show1(String str){
        System.out.println("我是一个"+str+"的人");
        return str;
    }

}
