package com.xulei.java;

import org.junit.Test;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-24 15:19
 * @since JDK 1.8
 */
public class StringTest {
    /**
     * String 是final的不可被继承
     * String实现了Serializable接口：表示字符串是支持序列化的
     * 实现了Comparable接口：表示可以比较大小
     * String内部定义了 final char[] value用于存储字符传数据
     * String:代表不可变的字符序列。简称不可变性
     */
    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * String的实例化方式
     * 方式一：字面量定义
     * 方式二：通过new + 构造器的方式
     */
    @Test
    public void test2() {

        //字面量定义，在方法区字符串常量池
        String s1 = "abc";
        String s2 = "abc";
        //通过new + 构造器的方式  ,数据在堆空间中
        String s3 = new String("abc");
        String s4 = new String("abc");
        //true
        System.out.println(s1 == s2);
        //false
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);
        System.out.println("-----------------");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        //true
        System.out.println(p1.name.equals(p2.name));
        //true
        System.out.println(p1.name == p2.name);

    }

    /**
     * 常量与常量拼接结果在常量池。常量池中不会有相同内容
     * 只要其中一个是变量，结果就在堆中
     * 如果拼接的结果低昂intern()方法，返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s5.intern();//返回值得到的S8，使用的常量值已经存在的"javaEEhadoop"
        System.out.println(s3 == s8);//true

        String s9 = (s1 + s2).intern();//如果拼接的结果低昂intern()方法，返回值就在常量池中
        System.out.println(s9 == s3);//true

    }


    @Test
    public void test4() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2+"hadoop";
        System.out.println(s1==s3);
        //常量与常量拼接结果在常量池。常量池中不会有相同内容
        final String s4="javaEE";
        String s5=s4+"hadoop";
        System.out.println(s1==s5);
    }

}


