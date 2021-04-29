package com.xulei.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author xl
 * @Description: collection
 * @date: 2021-04-28 21:07
 * @since JDK 1.8
 * <p>
 * collection 接口中实现类的对象中添加数据ob时，建议重写equals
 */
public class CollectionTest {
    /**
     * 是否包含某个元素
     *  boolean contains(Object obj)：是通过元素的equals方法来判断是否
     * 是同一个对象
     *  boolean containsAll(Collection c)：也是调用元素的equals方法来比
     * 较的。拿两个集合的元素挨个比较
     */
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));
        Person hxl = new Person("何小玲", 18);
        //1.contains(Object obj )：判断当前集合是否包含obj
        //我们在判断时会调用obj对象中类的equals方法
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("aa")));
        System.out.println(coll.contains(hxl));
        System.out.println("*****************************");
        //containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较
        Collection coll1 = Arrays.asList("aa", "BB", "CC");
        System.out.println(coll.containsAll(coll1));
    }

    /**
     * 删除
     *  boolean remove(Object obj) ：通过元素的equals方法判断是否是
     * 要删除的那个元素。只会删除找到的第一个元素
     *  boolean removeAll(Collection coll)：取当前集合的差集
     */
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));
        //remove(obj)从当前集合中移除obj元素
        boolean remove = coll.remove(1213);
        System.out.println(coll.remove(new Person("何小玲", 18)));
        System.out.println(coll);

        //removeAll(coll);从当前集合中移除coll1中所有的元素
        Collection collection = Arrays.asList("aa", 123);
        System.out.println(coll);
        System.out.println(coll.removeAll(collection));
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));

        //coll.retainAll()交集：获取当前集合和coll1集合的交集，并返回给当前集合   保留相同的元素  删除不同的元素
//        Collection collection = Arrays.asList("aa", 123);
//        System.out.println(coll);
//        System.out.println(coll.retainAll(collection));
//        System.out.println(coll);

        //equals(Object obj) 判断当前对象与OBJ对象元素是否相同
        Collection coll1 = new ArrayList();
        coll1.add("aa");
        coll1.add("BB");
        coll1.add("CC");
        coll1.add("DD");
        coll1.add(123);
        coll1.add(new Person("何小玲", 18));
        System.out.println(coll.containsAll(coll1));
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add(123);
        coll.add(new Person("何小玲", 18));
        //hashCode()返回对象的哈希值
        System.out.println(coll.hashCode());


        //集合——》数组
        Object[] objects = coll.toArray();
        for (Object obj:objects){
            System.out.println(obj);
        }

        //数组——》集合  调用Arrays类的静态方法asLise()
        List<Object> objects1 = Arrays.asList(objects);
        System.out.println(objects1);

        List<int[]> list = Arrays.asList(new int[]{123, 456});
        System.out.println(list.size());//1

        List list1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list1.size());//2


        //iterator();返回迭代器对象，用于集合遍历



    }
}


