package com.xulei.java;

import org.junit.Test;

import javax.swing.table.TableRowSorter;
import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author xl
 * @Description:通过反射创建对应的运行时类的对象
 * @date: 2021-05-12 22:57
 * @since JDK 1.8
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        //newInstance()：调用此方法，创建对应的运行时类的对象

        /*
         *1.运行时类必须提供空参的构造器
         * 2.空参的构造器的访问权限的够，通常设置为public
         * 通常使用这种方法newInstance()
         *
         *
         * 在javabean中要求提供一个public 的空参的构造器，原因
         *  1.便于通过反射，创建运行时类的对象
         *  2.便于子类继承运行时类时，默认调用super()时，保障父类有此构造器
         */
        //调用的空参的构造器
        Person  p1= clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        //调用私有的属性
        name.setAccessible(true);
        name.set(p1,"XuLei");
        System.out.println(p1);

    }

    /**
     * 体会反射的动态性
     */
    @Test
    public void test2(){
        int num =new Random().nextInt(3);//0,1,3
        String classPath = "";
        switch (num){
            case 0:
                classPath="java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.xulei.java.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * c创建一个指定的类的对象
     * @param classPath  指定类的全类名
     * @return  返回一个对象
     * @throws Exception
     */
    public Object getInstance(String classPath) throws  Exception{
        Class clazz =  Class.forName(classPath);
        return clazz.newInstance();

    }

}
