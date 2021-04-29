package com.xulei.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 自然排序：java.lang.Comparable
 * 定制排序：java.util.Comparator
 * @author xl
 * @Description:java中的比较器
 * @date: 2021-04-25 21:43
 * @since JDK 1.8
 */
public class CompareTest {


    @Test
    public void test1(){
        String[] arr={"aa","cc","dd","bb","jj"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test2(){
        Goods[] arr=new Goods[5];
        arr[0]=new Goods("小米",34);
        arr[1]=new Goods("联想",35);
        arr[2]=new Goods("华为",98);
        arr[3]=new Goods("a尔",15);
        arr[4]=new Goods("你尔",15);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 定制排序
     */
    @Test
    public void test3(){
        String[] arr={"aa","cc","dd","bb","jj"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  String && o2 instanceof  String){
                    String s1=(String)o1;
                    String s2=(String)o2;
                    return -s1.compareTo(s2);
                }
                return 0;
            }

        });
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 定制
     */
    @Test
    public void test4(){
        Goods[] arr=new Goods[5];
        arr[0]=new Goods("c米",34);
        arr[1]=new Goods("aaf",35);
        arr[2]=new Goods("gh为",98);
        arr[3]=new Goods("aac",15);
        arr[4]=new Goods("h尔",15);
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Goods && o2 instanceof Goods){
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                return -4;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
