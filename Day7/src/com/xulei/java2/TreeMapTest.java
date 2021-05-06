package com.xulei.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xl
 * @Description:TreeMap测试
 * @date: 2021-05-06 20:59
 * @since JDK 1.8
 */
public class TreeMapTest {

    //像TreeMap中添加Key-value，要求key必须是由同一个类创建的对象
    /**
     *    因为要以key排序
     */

    @Test
    public void test1(){
        TreeMap  tmap =new TreeMap();

        Person p1 = new Person("a何小玲", 18);
        Person p2 = new Person("x何小玲", 12);
        Person p3 = new Person("w何小玲", 19);
        Person p4= new Person("a何小玲", 171);
        tmap.put(p1,98);
        tmap.put(p2,92);
        tmap.put(p3,91);
        tmap.put(p4,100);

        Set set = tmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeMap map =new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person&&o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(),p2.getAge());

                }

                throw new RuntimeException("传入的类型有误");


            }
        });

        Person p1 = new Person("a何小玲", 18);
        Person p2 = new Person("x何小玲", 12);
        Person p3 = new Person("w何小玲", 19);
        Person p4= new Person("a何小玲", 171);
        map.put(p1,98);
        map.put(p2,92);
        map.put(p3,91);
        map.put(p4,100);
        Set set = map.entrySet();
        for(Object obj:set){
            System.out.println(obj);
        }

    }
}
