package com.xulei.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xl
 * @Description:  自定义泛型类
 * @date: 2021-05-07 17:13
 * @since JDK 1.8
 */
public class Order<T> {
    String orderName;
    int orderId;


    T orderT;

    public Order(){};


    public Order(String orderName,int orderId,T orderT){

        this.orderId=orderId;
        this.orderName=orderName;
        this.orderT=orderT;
    };


    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    //static的不能使用泛型
    public static void show(){

      //  System.out.println(orderT);
    }

    /**
     * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
     * 
     * @param arr
     * @param <E>
     * @return
     */
    public <E>List<E> copyList(E[] arr){
        ArrayList<E> list =new ArrayList<>();
        for (E e :arr){
            list.add(e);
        }
        return list;
    }

}
