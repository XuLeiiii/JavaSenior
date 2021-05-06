package com.xulei.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xl
 * @Description:操作Collections、map的工具类
 * @date: 2021-05-06 21:25
 * @since JDK 1.8
 */
public class CollectionsTest {
    /**
     * /*
     * reverse(List)：反转 List 中元素的顺序
     * shuffle(List)：对 List 集合元素进行随机排序
     * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     *
     * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection，Comparator)
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     * void copy(List dest,List src)：将src中的内容复制到dest中
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
     *
     *
     */
    /**
     * copy(List dest,List src)：将src中的内容复制到dest中
     */
    @Test
    public void test2(){
        List list =new ArrayList();
        list.add(1);
        list.add(8);
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(3);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest,list);
        System.out.println(dest);

        //返回线程安全的list
        List list2 = Collections.synchronizedList(list);
    }


    @Test
    public void test1(){
        //reverse(List)：反转 List 中元素的顺序
        List list =new ArrayList();
        list.add(1);
        list.add(8);
        list.add(4);
        list.add(3);
        list.add(3);
        list.add(3);
        System.out.println(list);
        // reverse(List)：反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);

        //shuffle(List)：对 List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);
        //sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        //Collections.sort(list);
        System.out.println(list);
        //swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list,1,2);
        System.out.println(list);

        //max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素  自然排序
        Comparable max = Collections.max(list);
        System.out.println("list中最大的元素"+max);
        //min(Collection)：根据元素的自然顺序，返回给定集合中的最小元素  自然排序
        System.out.println("list中小的元素"+Collections.min(list));

        //frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        int frequency = Collections.frequency(list,3);
        System.out.println("obj出现的次数"+frequency);
    }


}
