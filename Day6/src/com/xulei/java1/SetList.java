package com.xulei.java1;

import com.xulei.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author xl
 * @Description: Set集合
 * @date: 2021-04-28 23:35
 * @since JDK 1.8
 *
 * Set接口是Collection的子接口，set接口没有提供额外的方法
 * Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set 集合中，则添加操作失败。
 * Set 判断两个对象是否相同不是使用 == 运算符，而是根据 equals() 方法
 *  Collection
 *         Set
 *              HashSet:作为Set接口的主要实现类：线程不安全的；可以存储null值
 *                  LinkedHashSet:作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                                  遍历的效率高
 *              TreeSet：可以按照添加元素的指定属性，进行排序
 *
 */
public class SetList {

    /**
     * 无序性：不等于随机性  。存储得到数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值添加
     *
     * 不可重复性：保证添加得额元素按照equals()判断时，不能返回true即：相同的元素只能添加一个
     *
     *
     * 必须要重写HashSet()、
     * equals()方法
     */


    @Test
    public void test1(){
        Set hashSet=new HashSet();
        hashSet.add("dd");
        hashSet.add("bb");
        hashSet.add("cc");
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add(new Person("何小玲",18));
        hashSet.add(new Person("何小玲",18));
        hashSet.add(852);

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    /**
     * linkedHashList的使用
     * LinkedHashList作为HashList的子类，在添加数据的同事，每个数据还维护了两个引用，记录此数据的前后数据
     * 优点：遍历的效率高
     */
    @Test
    public void test2(){
        Set hashSet=new LinkedHashSet();
        hashSet.add("dd");
        hashSet.add("bb");
        hashSet.add("cc");
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add(new Person("何小玲",18));
        hashSet.add(new Person("何小玲",18));
        hashSet.add(852);

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
