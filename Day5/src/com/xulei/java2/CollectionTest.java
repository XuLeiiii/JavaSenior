package com.xulei.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description: 集合框架
 * @date: 2021-04-28 19:52
 * @author xl
 * @since JDK 1.8
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *
 * 2.1数组在存储多个数据方面的特点
 *             》一旦初始化以后，其长度就确定
 *             》需要指定元素类型，数组一旦定义好，其元素的类型也就确定了
 * 2.2数组在存储多个数据方面的缺点：
 *             》一旦确定后无法更改长度
 *             》数组中提供的方法非常有限， 对于添加、删除、插入等操作非常不便，效率不高
 *             》获取数组中实际元素的个数的需求，数组没有现成的属性和方法可用
 *             》数组存储数据的特点：有序，可重复。对于无序，不可重复的需求，不能满足
 *
 * Java 集合可分为 Collection 和 Map 两种体系
 *  Collection接口：单列数据，用来存储一个一个得对象
 *      List：存储元素有序、可重复的集合  （动态数组）
 *                ArrayList、linkedList、Vector
 *      Set：存储元素无序、不可重复的集合
 *              HashSet、LinkedHashSet 、TreeSet
 * Map接口：双列数据，保存具有映射关系“key-value对”的集合    用来存储一对数据
 *               HashMap、linkedHashMap、TreeMap、Hashtable、Properties
 */
public class CollectionTest {
    /**
     * 1、添加 add(Object obj)
     *  addAll(Collection coll)
     * 2、获取有效元素的个数 int size()
     * 3、清空集合 void clear()
     * 4、是否是空集合 boolean isEmpty
     */
    @Test
    public  void test1(){
        Collection con =new ArrayList();
        //add() 添加元素到集合
        con.add("aaa");
        con.add("ddd");
        con.add("222");
        con.add("444");
        con.add("bbb");
        //获取元素个数
        System.out.println(con.size());

        //addAll()
        Collection con1 =new ArrayList();
        con1.add("asd");
        con1.add("qwe");
        con1.addAll(con);
        System.out.println(con1);

        //clear();清空集合元素

        con.clear();

        //判断集合是否为空
        System.out.println(con.isEmpty());
    }



}
