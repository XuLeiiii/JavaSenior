package com.xulei.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 17:16
 * @since JDK 1.8
 */
public class GenericTest1 {

    @Test
    public void test4a(){
        Order<String> order =new Order<>();
        Integer[] arr =new Integer[]{1,6,2,4};
        //调用泛型方法
        List<Integer> list =order.copyList(arr);
        System.out.println(list);
    }

    @Test
    public void test3(){
        //
        ArrayList<String> arrayList=null;
        ArrayList<Integer>  integers=null;
        //泛型不同的引用不能相互赋值
//        arrayList=integers;

    }


    @Test
    public void test2(){
        SubOrder sub =new SubOrder();
        //由于子类在继承带泛型类的父类时，指明了泛型类型，则实例化子类对象时，不需要指明泛型
        sub.setOrderT(2111);


        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("aaa");
    }



    @Test
    public void test(){
        Order order= new Order();
        //如果定义了泛型类，实例化没有指定类的泛型，默认泛型类型为Object
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明泛型
        order.setOrderT(123);
        order.setOrderT("avc");


        //建议：实例化时指明类的泛型
        Order<String > order1 =new Order<>("hxl",18,"aa");
        order1.setOrderT("aa:hello");
    }
}
