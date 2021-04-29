package com.xulei.java;

import org.junit.Test;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-24 21:10
 * @since JDK 1.8
 */
public class StringBufferBuilderTest {


    /**
     * 对比效率
     */
    @Test
    public void test3() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }

    /**
     * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接  增
     * StringBuffer delete(int start,int end)：删除指定位置的内容  删
     * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * StringBuffer reverse() ：把当前字符序列逆转
     * <p>
     * public int indexOf(String str)
     * public String substring(int start,int end)
     * public int length()
     * public char charAt(int n )
     * public void setCharAt(int n ,char ch)
     * <p>
     * 增：append(xxx)
     * 删；delete(int start,int end)：删除指定位置的内容
     * 改:setCharAt(int n ,char ch)/replace(int start, int end, String str)：把[start,end)位置替换为str
     * 查:charAt(int n)
     * 插:insert(int offset, xxx)：在指定位置插入xxx
     * 长度:Length();
     * 遍历；.toString
     */
    @Test
    public void test2() {
        StringBuffer s = new StringBuffer("abc");
        s.append(1);
        s.append("1");
        System.out.println(s);
        s.delete(3, 5);
        System.out.println(s);

    }


    /**
     * String 、StringBuffer 、StringBuilder
     * String:不可变的字符串序列；底层使用char数组  final char数组
     * StringBuffer:可变的字符串序列；线程安全的,效率不高；底层使用char数组
     * StringBuilder:可变的字符串序列；JDK5.0新增的线程不安全的，效率高；底层使用char数组
     * <p>
     * 源码分析：
     * String str1= new String();//new char[0];
     * String str2= new String("abc");//char value =new char[]{'a','b','c'};
     * <p>
     * StringBuffer sb1 =new StringBuffer();new char[16];底层创建了一个长度为16的数组
     * <p>
     * StringBuffer sb2 =new StringBuffer("abc");new char[abc.length()+16];字符串长度加16
     * <p>
     * //问题1：System.out.println(sb2.length);//输出为3
     * //问题2：扩容问题：如果要添加的数据底层数据装不下了，那就需要扩容底层数组
     * 默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新数组
     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);
    }
}
