package com.xulei.java;

import java.io.Serializable;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-10 23:14
 * @since JDK 1.8
 * 需要满足一些要求
 *      1.需要实现接口Serializable
 *      2.需要当前类提供一个全局常量serialVersionUID
 *      3.除了当前类需要实现Serializable接口外，还需要保证内部所有属性
 *          也必须是可序列化的；基本数据类型默认情况下是可序列化
 *
 *      补充：不能序列化static和transient修饰的成员
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 425454568541L;
    private String name;
    private int age;

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
}
