package com.xulei.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author xl
 * @Description:JDK8中的日期时间测试
 * @date: 2021-04-25 20:47
 * @since JDK 1.8
 */
public class NewDateTest {
    /**
     * 本地日期（LocalDate）、本地时间（LocalTime）、本地日期时间（LocalDateTime）
     * 时区（ZonedDateTime）和持续时间（Duration）的类。
     * LocalDate代表IOS格式（yyyy-MM-dd）的日期,可以存储 生日、纪念日等日期。
     * LocalTime表示一个时间，而不是日期。
     * LocalDateTime是用来表示日期和时间的，这是一个最常用的类之
     */
    @Test
    public void test1() {
        //now()获取当前日期、时间、日期+时间  根据当前时间创建对象/指定时区的对象
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(date);
        System.out.println(time);
        System.out.println(localDateTime);
        //设置指定的年月日时分秒  根据指定日期/时间创建对象
        LocalDateTime of = LocalDateTime.of(1992, 8, 2, 20, 58, 58);
        System.out.println(of);

        System.out.println("********************************");
        //getXxx();获取
        //getDayOfMonth()/getDayOfYear() 获得月份天数(1-31) /获得年份天数(1-366)
        //getDayOfWeek() 获得星期几(返回一个 DayOfWeek 枚举值)
        //getMonth() 获得月份, 返回一个 Month 枚举值
        //getMonthValue() / getYear() 获得月份(1-12) /获得年份
        //getHour()/getMinute()/getSecond() 获得当前对象对应的小时、分钟、秒
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println("********************************");

        //withXxx();设置时间  将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
        //withDayOfMonth()/withDayOfYear()/
        //withMonth()/withYear()
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println("********************************");
        LocalDateTime localDateTime2 = localDateTime.withHour(5);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println("********************************");
        //plusXxx(); 向当前对象添加几天、几周、几个月、几年、几小时
        //plusDays(), plusWeeks(),
        //plusMonths(), plusYears(),plusHours()
        LocalDateTime localDateTime3 = localDateTime.plusHours(5);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
        System.out.println("********************************");
        //minusXxx();减时间  从当前对象减去几月、几周、几天、几年、几
        //minusMonths() / minusWeeks()/
        //minusDays()/minusYears()/minusHours()
        LocalDateTime localDateTime4 = localDateTime.minusHours(5);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

    }

    /**
     * now() 静态方法，返回默认UTC时区的Instant类的对象
     * ofEpochMilli(long epochMilli) 静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒
     * 数之后的Instant类的对象
     * atOffset(ZoneOffset offset) 结合即时的偏移来创建一个 OffsetDateTime
     * toEpochMilli() 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
     */
    @Test
    public void testInstant() {
        //第一种   获取的本初子午线对应的标准时间
        Instant now = Instant.now();
        System.out.println(now);


        //第二种方式  添加时间偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


        //获取对应的毫秒数  toEpochMilli()
        long l = now.toEpochMilli();
        System.out.println(l);

        //通过给定的毫米数获取时间
        Instant instant = Instant.ofEpochMilli(1555045857845L);
        System.out.println(instant);
    }

    /**
     * DateTimeFormatter
     */
    @Test
    public void test3() {

        //方式一：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);

        //解析
        TemporalAccessor parse = isoLocalDateTime.parse("2021-04-25T21:23:32.327");
        System.out.println(parse);

        //方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String format1 = timeFormatter.format(localDateTime);
        System.out.println(format1);

        //方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = dateTimeFormatter.format(localDateTime);
        System.out.println(format2);
        //解析
        TemporalAccessor parse1 = dateTimeFormatter.parse("2021-04-25 09:31:24");
        System.out.println(parse1);
    }
}
