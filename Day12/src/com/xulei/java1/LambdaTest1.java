package com.xulei.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author xl
 * @Description: Lambda表达式的使用
 * @date: 2021-05-13 22:59
 * @since JDK 1.8
 * <p>
 * 1.举例  Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
 * 2.格式：
 *      ->：Lambda操作符 或箭头操作符
 *      ->左边:Lambda形参列表 （其实就是接口中的抽象方法的形参列表）
 *      ->右边:Lambda体 （其实就是重写的抽象方法的方法体）
 * 3.Lambda表达式的使用：6种情况介绍
 *      ->左边:Lambda形参列表d的参数类型可以省略（类型推断：数据类型可以省略），如果只有一个参数，()小括号可以省略
 *      ->右边:Lambda体应该使用一堆{}包裹;如果Lambda体只有一条执行语句（可能是return语句）,可以省略这一对大括号{}和return关键字
 *
 * 4.Lambda表达式的本质：作为函数式接口的实例
 *
 * 5.如果一个接口中，只声明了一个抽象方法，则接口就是函数式接口
 */
public class LambdaTest1 {

    /**
     * 语法格式一：无参,无返回值
     */
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱成都");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("我爱北京");
        r2.run();
    }

    /**
     * 语法格式二：Lambda需要一个参数，但是没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("你好？");

        System.out.println("**************");

        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("你不好?");
    }

    /**
     * 语法格式三：数据类型可以省略 ，因为可由便有其推断得出，称为类型推断
     */
    @Test
    public void test3(){
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("你好？");

        System.out.println("**************");
        //省略了数据类型
        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("你不好?");
    }

    /**
     * 语法格式四：Lambda只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test4(){
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("你好？");

        System.out.println("**************");
        //省略了小括号  只有一个参数的情况下
        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("你不好?");
    }

    /**
     * 语法格式五：需要两个或以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com1.compare(12,21));
        System.out.println("************************");

        Comparator<Integer> con2 =(o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };

        System.out.println(con2.compare(12,6));
    }


    /**
     * 语法格式六：Lambda体只有一条语句时，return与大括号若有，都可以省略
     */
    @Test
    public void test6(){
        Comparator<Integer> con1 =(o1,o2) -> {
            return Integer.compare(o1,o2);
        };

        System.out.println(con1.compare(12,6));

        System.out.println("*******************************");
        Comparator<Integer> con2 =(o1,o2) ->  Integer.compare(o1,o2);


        System.out.println(con2.compare(12,6));
    }

    @Test
    public void test7(){
        Consumer<String> con1=s->{
            System.out.println(s);
        };
        con1.accept("你好吗？");

        Consumer<String> con2 =s -> System.out.println(s);

        con2.accept("你好");

    }
}
