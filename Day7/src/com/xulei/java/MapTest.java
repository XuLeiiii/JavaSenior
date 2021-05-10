package com.xulei.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xl
 * @ClassName: MapTest
 * @Description:  Map:双列数据，存储 key-value的数据
 * @date: 2021-05-06 14:38
 * @since JDK 1.8
 *     Map:双列数据 存储key -value对的数据
 *          HashMap:Map的主要实现类；线程不安全的；效率高：可以存储null的的key和value值
 *              LinkedHashMap:保证在在遍历map元素时，可以按照添加的顺序实现遍历
 *                              原因：在原有的HashMap底层结构基础上，添加了一堆指针，指向前后
 *          TreeMap:保证按照添加的key-value对进行排序，实现排序遍历，使用key的自然排序和定制排序
 *                  底层使用红黑树
 *          Hashtable:古老的实现类使用类；线程安全的，效率低；不能存储null的的key和value值
 *              Properties:常用来处理配置文件，key和value都是String类型
 *
 *
 *
 ***
 */
public class MapTest {
    @Test
    public void test1(){
        Map map =new HashMap();
        map.put(1,123);
        map.put(1,456);
        System.out.println();

    }

}
