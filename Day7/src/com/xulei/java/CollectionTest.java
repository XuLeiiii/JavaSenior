package com.xulei.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-05 21:08
 * @since JDK 1.8
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(78);
        coll.add(654);
        coll.add(789);
        coll.forEach(System.out::println);


    }
}


