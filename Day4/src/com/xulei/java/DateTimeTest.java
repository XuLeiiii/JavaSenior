package com.xulei.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-25 17:54
 * @since JDK 1.8
 */
public class DateTimeTest {

    /**
     * SimpleDateFormat的使用
     * 1 两个操作
     * 1.1 格式化：日期——>字符串
     * 1.2 解析：格式话的逆过程
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);

        //解析
        String str = "19-12-18 上午11:49";
        Date parse1 = sdf.parse(str);
        // SimpleDateFormat sdf1=new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm  aaa");


        //指定格式化和解析
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String format1 = sdf1.format(date);
        //2021-04-25  06:19:34
        System.out.println(format1);
        //解析
        Date parse = sdf1.parse("2021-04-25  06:19:34");
        System.out.println(parse);
    }

    /**
     * 练习一
     */
    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2020-09-08";
        Date parse = sdf.parse(str);
        java.sql.Date sDate = new java.sql.Date(parse.getTime());
        System.out.println(sDate);

    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //86400000 一天的毫秒数
        String s1 = "1990-01-01";
        String s2 = "1990-01-04";
        Date parse = sdf.parse(s1);
        Date parse1 = sdf.parse(s2);
        long time = parse1.getTime() - parse.getTime();
        long dd = time / 86400000+1;
        if (dd % 5 == 1 || dd % 5 == 2 || dd % 5 == 3) {
            System.out.println("在打鱼");
        } else if (dd % 5 == 4 || dd % 5 == 0) {
            System.out.println("在筛网");
        }
    }

    /**
     * Calendar 日历类
     *  public void set(int field,int value)
     *  public void add(int field,int amount)
     *  public final Date getTime()
     *  public final void setTime(Date date)
     */
    @Test
    public void testCalendar(){
        //实例化
        //方式一创建其子类
        //方式二：调用其静态方法getInstance();
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
    }

}
