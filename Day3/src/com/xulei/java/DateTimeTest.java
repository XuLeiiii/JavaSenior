package com.xulei.java;

import org.junit.Test;

import java.util.Date;

/**
 *
 *
 * @author xl
 * @Description:JDK8之前日期和时间API的测试
 * @date: 2021-04-24 21:45
 * @since JDK 1.8
 */
public class DateTimeTest {

    /**
     * java.util.Date
     *          java.sql.Date
     *
     * 1.两个构造器的使用
     *      //构造器一：Date 创建了当前时间的一个Date对象
     *         Date date = new Date();
     *
     *       //构造器二：创建指定毫秒的时间对象
     *         Date date1 = new Date(1619272494770L);
     * 2.两个方法的使用
     *          .toString()返回年月日时分秒 星期
     *          .getTime();获取当前Date对象对应的毫米数
     *
     * 3.java.sql.Date 对应数据库中的日期类型的变量
     */
    @Test
    public void test2(){
        //构造器一：Date 创建了当前时间的一个Date对象
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());


        //构造器二：创建指定毫秒的时间对象
        Date date1 = new Date(1619272494770L);
        System.out.println(date1.toString());
        /* 创建来一个java.sql.Date的方法 */
        java.sql.Date date2 = new java.sql.Date(16192724720L);//1970-07-07
        System.out.println(date2);

        //将java.util.Date转换为java.sql.Date
        Date date6=new Date(16192724720L);
        java.sql.Date date7=new java.sql.Date(date6.getTime());
        System.out.println(date6);
        System.out.println(date7);
    }

    /**
     * System中
     * currentTimeMillis()
     * 回当前时间与1970年1月1日0时0分米0秒之间以毫秒为单位的时间差
     */
    @Test
    public void test1(){
        //返回当前时间与1970年1月1日0时0分米0秒之间以毫秒为单位的时间差
        //称为时间戳
        long time=System.currentTimeMillis();
        System.out.println(time);
    }
}
