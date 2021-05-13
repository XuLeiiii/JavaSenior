package com.xulei.java2;

import com.xulei.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xl
 * @ClassName: ReflectionTest
 * @Description:  调用运行时类中指定的结构：属性、方法、构造器
 * @date: 2021-05-13 16:28
 * @since JDK 1.8
 */
public class ReflectionTest {

    /**
     * 不理想
     * @throws Exception
     */
    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;
        //创建运行时的对象
        Person p = clazz.newInstance();

        //获取指定的属性   要求运行时类中属性为public的
        //通常不使用该方法
        Field id = clazz.getField("id");

        /*设置属性的值
        set()；
                参数1：指明设置那个对象的属性  参数2：将此属性值设置为多少
        */
        id.set(p,18);
        System.out.println();
        /*
         *获取当前属性的值
         * get();指明需要获取那个对象的属性
         */
        int o = (int)id.get(p);
        System.out.println(o);

        System.out.println("************");
    }

    /**
     * 然后操作运行时类的属性
     * @throws Exception
     */
    @Test
    public void testField1() throws Exception{
        Class<Person> clazz = Person.class;
        //创建运行时类的对象
        Person p = clazz.newInstance();
        //1.getDeclaredField()获取运行时类中指定变量名的属性  运行时类所有的方法
        Field age = clazz.getDeclaredField("age");
        //2.保证当前属性是可以访问的
        age.setAccessible(true);
        //3.设置指定对象的属性值
        age.set(p,18);

        System.out.println(age.get(p));

    }

    /**
     * 获取运行时类的指定方法
     */
    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz  =Person.class;
        //创建运行时类的对象
        Person p = clazz.newInstance();
        //获取指定某个方法
        //getDeclaredMethod()参数1指定获取的方法的名称， 参数2指定获取方法的形参
        Method nation = clazz.getDeclaredMethod("nation", String.class);
        //保证当前方法是可以访问的
        nation.setAccessible(true);

        //调用方法invoke();参数1：方法的调用者  参数2：给方法形参赋值的实参
        String obj = (String) nation.invoke(p, "中国");
        System.out.println(obj);
        System.out.println("***********************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行类中的方法没有返回值，则invoke()返回null
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);


    }

    /**
     * 获取指定的构造器
     * @throws Exception
     */
    @Test
    public void test() throws Exception{

        Class<Person> clazz  =Person.class;
        //获取指定的构造器
        //getDeclaredConstructor()：参数：指明构造器的参数列表
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        //保证构造器可访问
        constructor.setAccessible(true);

        //调用此构造器创建运行时类的对象
        Person p = constructor.newInstance("xulei");
        System.out.println(p);
    }

}
