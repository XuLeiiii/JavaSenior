package com.xulei.java;

import org.junit.Test;

import java.util.*;

/**
 * @author xl
 * @Description: 泛型的使用
 * @date: 2021-05-07 16:35
 * @since JDK 1.8
 */
public class GenericTest {


    /**
     * HashMap使用泛型
     */
    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<String,Integer>(16);
        map.put("hxl",100);
        map.put("mm",88);
        map.put("hbl",150);
        map.put("xl77",70);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        //泛型的嵌套
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()){
          Map.Entry<String,Integer> e =iterator.next();
          String name = e.getKey();
          int num = e.getValue();
            System.out.println("姓名："+name+" 成绩："+num);
        }
    }


    /***
     * 在集合中使用泛型
     * 泛型不能是基本数据类型
     */
    @Test
    public void test2(){
        //使用泛型限制集合类型
        ArrayList<Integer>  list =new ArrayList<Integer>();
        list.add(78);
        list.add(55);
        list.add(87);
        list.add(68);
        //编译时，就会进行类型检查，保证数据的安全
        //list.add("aaa");
//        for (Integer score : list) {
//            //避免了强转操作
//            int stuScore =  score;
//            System.out.println(stuScore);
//        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore =  iterator.next();
            System.out.println(stuScore);
        }
    }

    /**
     * 在集合中时使用泛型之前的情况
     */
    @Test
    public void test1() {
        ArrayList list = new ArrayList();

        list.add(78);
        list.add(78);
        list.add(87);
        list.add(68);
        list.add(95);
        //类型不安全
        // list.add("hxl");

        for (Object score : list) {
            //强转时可能出现ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);
        }
    }


}
