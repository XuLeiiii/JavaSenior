package com.xulei.java;

import org.junit.Test;

/**
 * @author xl
 * @Description:通过反射创建对应的运行时类的对象
 * @date: 2021-05-12 22:57
 * @since JDK 1.8
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        //newInstance()：调用此方法，创建对应的运行时类的对象

        /*
         *1.运行时类必须提供空参的构造器
         * 2.空参的构造器的访问权限的够，通常设置为public
         */
        Person  p1= clazz.newInstance();
        System.out.println(p1);

    }

}
