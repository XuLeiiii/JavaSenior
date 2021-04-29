package com.xulei.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author xl
 * @Description:  list 集合  常用方法
 * @date: 2021-04-28 22:15
 * @since JDK 1.8
 * ArrayList：线程不安全  效率高 ；底层使用Object[]存储  elementData存储
 *LinkedList：对于频繁插入、删除操作，使用此类效率比ArrayList效率高，底层使用双向链表存储
 * vector： 线程安全 效率低：    底层使用Object[]存储  elementData存储
 *
 * 面试题：ArrayList 、LinkedList 、vector 三者的异同
 * 同：三个类都实现了List解耦 ，存储数据的特点相同，有序的、可重复
 *  * ArrayList：线程不安全  效率高 ；底层使用Object[]存储  elementData存储
 *  *LinkedList：对于频繁插入、删除操作，使用此类效率比ArrayList效率高，底层使用双向链表存储
 *  * vector： 线程安全 效率低：    底层使用Object[]存储  elementData存储
 */
public class ListTest {

    @Test
    public void test3(){
        ArrayList list =new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    /**
     * 区分
     */

    private static void updateList(List list){
        list.remove(2);
        list.remove(new Integer(1));
    }

    @Test
    public void test2(){
        ArrayList list =new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add(123);
        list.add(new Person("何小玲",18));


        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Object obj:list){
            System.out.println(obj);
        }

        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    /**
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
     */
    @Test
    public void test1(){
        ArrayList list =new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add(123);
        list.add(new Person("何小玲",18));
        System.out.println(list);
        //void add(int index, Object obj)在index位置插入ele元素
        list.add(1,"徐磊");
        System.out.println(list);


        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1= Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list);


        // get(int index):获取指定index位置的元素
        System.out.println(list.get(4));

        //indexOf(Object obj):返回obj在集合中首次出现的位置  判断obj首次出现索引位置

        int is = list.indexOf("徐磊");
        System.out.println(is);

        //lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置 判断obj最后一次出现索引位置
        System.out.println(list.lastIndexOf(123));

        //remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(2));

        // set(int index, Object ele):设置指定index位置的元素为ele
        System.out.println(list.set(1,"何宝玲"));
        System.out.println(list);
        //subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        List list2 = list.subList(0, 3);
        System.out.println(list2);

    }


}
