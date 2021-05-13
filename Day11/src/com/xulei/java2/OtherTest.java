package com.xulei.java2;

import com.xulei.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author xl
 * @ClassName: OtherTest
 * @Description:
 * @date: 2021-05-13 16:05
 * @since JDK 1.8
 */
public class OtherTest {

    /**
     * 获取构造器结构
     */

    @Test
    public void test1() throws NoSuchMethodException {
        Class  clazz = Person.class;
        //获取当前运行时类声明为public的构造器
        Constructor[] Constructor = clazz.getConstructors();
        for (Constructor c :Constructor){
            System.out.println(c);
        }

        System.out.println();
        //获取当前运行时类中声明的所有构造器了
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c :declaredConstructors){
            System.out.println(c);

        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test2(){
        Class clazz =Person.class;
        //获取运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取运行时类带泛型的父类
     */
    @Test
    public void test3(){
        Class clazz =Person.class;
        //获取运行时类的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /**
     * 获取运行时类带泛型的父类的泛型
     */
    @Test
    public void test4(){
        Class clazz =Person.class;
        //获取运行时类的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = type.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz =Person.class;
        //获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class i:interfaces ){
            System.out.println(i);
        }

        System.out.println();
        //获取运行时类的父类的实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class i :interfaces1){
            System.out.println(i);
        }


    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test6(){
        Class clazz =Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /**
     * 获取运行时类的注解
     */
    @Test
    public void test7(){
        Class clazz =Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a:annotations){
            System.out.println(a);
        }
    }
}
