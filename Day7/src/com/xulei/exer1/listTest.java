package com.xulei.exer1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-05 21:57
 * @since JDK 1.8
 */
public class listTest {
    //练习：在list内去除重复值，要求简单
    public static List duplicateList(List list) {
        //声明一个HashSet()利用它不重复的特性
        HashSet set = new HashSet();
        //添加list集合到set集合里  自动去除重复
        set.addAll(list);
        //返回list
        return new ArrayList(set);
    }

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        List list2 = duplicateList(list);
        list2.forEach(System.out::println);
    }

    @Test
    public void test3() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }

}
