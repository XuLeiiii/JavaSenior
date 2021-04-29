package com.xulei.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author xl
 * @Description:  Iterator遍历集合
 * @date: 2021-04-28 21:44
 * @since JDK 1.8
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));

        Iterator iterator = coll.iterator();

        //方式一：不推荐
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 错误的遍历方式
     */
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));

        //错误方式一
//        Iterator iterator = coll.iterator();
//        while (iterator.next()!=null){
//            System.out.println(iterator.next());
//        }

        //错误方式二
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }

    }

    @Test
    public void tese3(){
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));
        //remove()删除指定对象
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            Object obj =iterator.next();
            if(obj.equals("aa")){
                iterator.remove();
            }
        }
        System.out.println("*************************");
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

}
