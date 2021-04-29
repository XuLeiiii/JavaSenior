package com.xulei.java1;

import com.xulei.java.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-29 0:32
 * @since JDK 1.8
 */
public class TreeSetTest {
    /**
     * TreeSet中添加的数据，要求是相同类对象
     */
    @Test
    public void test1() {
        Set set = new TreeSet();
        set.add(34);
        set.add(54);
        set.add(32);
        set.add(3);
        set.add(78);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set set1 = new TreeSet();
        set1.add(new Person("d小玲", 18));
        set1.add(new Person("j小玲", 15));
        set1.add(new Person("c小玲", 16));
        set1.add(new Person("a小玲", 12));
        set1.add(new Person("a小玲", 13));
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    @Test
    public void test3() {

        Comparator cot = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Person && o2 instanceof  Person){
                    Person p1= (Person) o1;
                    Person p2= (Person) o2;
                    return  p1.compareTo(p2);
                }else{
                    throw new RuntimeException("输入的不对");
                }

            }
        };
        Set set1 = new TreeSet(cot);
        set1.add(new Person("d小玲", 18));
        set1.add(new Person("j小玲", 15));
        set1.add(new Person("c小玲", 16));
        set1.add(new Person("a小玲", 12));
        set1.add(new Person("a小玲", 14));
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }
}
