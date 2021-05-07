package com.xulei.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 18:16
 * @since JDK 1.8
 */
public class GenericTest {
    /**
     * 泛型在继承方面的体现
     */

    @Test
    public void test1() {
        Object obj = null;
        String str = null;

        obj = str;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1 和list2的类型不具备子父类关系
        //编译不通过
//       list1 = list2;

    }

    /**
     * 通配符的使用
     */
    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;


        List<String> list3 = new ArrayList<>();
        list3.add("aa");
        list3.add("bb");
        list3.add("cc");
        list3.add("dd");
        list = list3;

        //添加  List<?>  就不能想其内部添加数据  除了添加null之外
        //编译错误
//        list.add("aa");
        list.add(null);

        //获取(读取) 允许读取数据， 读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }


    /**
     * 有限制条件的通配符的使用
     */

    public void test3() {
        //<=
        List<? extends Person> list1 = null;
        //>=
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 =list5;


//        list2 = list3;
        list2 = list4;
        list2 = list5;

    }
}
