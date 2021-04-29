package com.xulei.java;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-28 17:16
 * @since JDK 1.8
 * <p>
 * 枚举类的实现
 * JDK1.5之前需要自定义枚举类
 * JDK 1.5 新增的 enum 关键字用于定义枚举类
 * 若枚举只有一个对象, 则可以作为一种单例模式的实现方式。
 * <p>
 * 枚举类的属性
 * 枚举类对象的属性不应允许被改动, 所以应该使用 private final 修饰
 * 枚举类的使用 private final 修饰的属性应该在构造器中为其赋值
 * 若枚举类显式的定义了带参数的构造器, 则在列出枚举值时也必须对应的传入参数
 * <p>
 * <p>
 * 1. 私有化类的构造器，保证不能在类的外部创建其对象
 * 2. 在类的内部创建枚举类的实例。声明为：public static final
 * 3. 对象如果有实例变量，应该声明为private final，并在构造器中初始化
 *
 *

 */
public class SeasonTst {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}

/**
 * 自定义枚举类
 */

class Season {
    /**
     *  声明对象的属性 使用private final修饰
     */
    private final String seasonName;
    private final String seasonDesc;

    /**
     * 私有化构造器,并给对象属性赋值
     */
    private Season(String seasonName,String seasonDesc) {
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }

    /**
     * 3.提供当前枚举类的多个对象
     */
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
