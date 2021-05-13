package com.xulei.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author xl
 * @Description:  java内置的4大核心函数式接口
 * @date: 2021-05-13 23:34
 * @since JDK 1.8
 *
 * 消费型接口  Consumer<t>  void accept(T  t)
 * 供给型接口  Supplier<t>  T get()
 * 函数型接口  FUnction<T,R>   R apply(T t)
 * 断定型接口 Predicate<t>  boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了,休息一下买瓶水价格为"+aDouble);
            }
        });
        System.out.println("*************************");
        happyTime(400,money-> System.out.println("学习太累了,买瓶水价格为"+money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京","成都");
        List<String> filterStr = filerString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStr);

        System.out.println("*********************");
        List<String> filterStr1=filerString(list,s -> s.contains("京"));//contains(String str)是否包含指定字符返回Boolean值
        System.out.println(filterStr1);
    }

    /**
     * 根据给定的规则，过滤集合中的字符串，此规则有Predicate的方法决定
     * 传入一个list集合  如果符合一个规则就放在一个新集合里返回
     * @param list   字符串集合
     * @param pre  实现一个规则过滤list集合里的字符串
     * @return  返回一个符合规则的集合
     */
    public List<String> filerString(List<String> list , Predicate<String> pre){
        List<String> filterList = new ArrayList<>();
        for (String s :list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
