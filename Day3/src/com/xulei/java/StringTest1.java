package com.xulei.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xl
 * @Description:涉及到String类与其他结构之间的转换
 * @date: 2021-04-24 20:36
 * @since JDK 1.8
 */
public class StringTest1 {

    /**
     * String 与byte[]之间的转换
     *
     */
    @Test
    public void  test3(){
        //String转换为byte[]数组  编码
        String st1="123ab";
        byte[] by=st1.getBytes();
        System.out.println(Arrays.toString(by));

        //byte[]数组转换为String   解码
        String str2 =new String(by);
        System.out.println(str2);
    }

    @Test
    public void test2(){
        //字符串转换为char数组
        String str1="abc123";
        char[] charArray=str1.toCharArray();
        for(char c:charArray) {
            System.out.print(c);
        }
        //char数组转换为字符串  调用String的构造器
        char[] arr ={'h','a','d','s','d'};
        String str2= new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test1(){
        //String转换为基本数据类型  包装类.parseXxx()
        String str1 ="123";
        int num =Integer.parseInt(str1);

        //基本数据类型转换为String  String.valueOf();
        String str2=String.valueOf(num);
        System.out.println(str2);
    }
}
