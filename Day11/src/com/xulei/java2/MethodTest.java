package com.xulei.java2;

import com.xulei.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author xl
 * @ClassName: MethodTest
 * @Description:获取运行时类的方法结构
 * @date: 2021-05-13 15:22
 * @since JDK 1.8
 */
public class MethodTest {

    @Test
    public void test1(){
        Class clazz = Person.class;
        //getMethods() 获取运行时类public的方法及其父类的public的所有方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }

        System.out.println("***********************");
        //获取当前运行时类中声明的方法（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods){
            System.out.println(m);
        }

    }

    /**
     * 获取方法的  权限修饰符  返回值类型 方法名（参数类型）  throws  xxxException
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        //获取当前运行时类中声明的方法（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods){

            //1.获取方法类的注解
            Annotation[] annotations = m.getAnnotations();
            for(Annotation a : annotations){
                System.out.println(a);
            }

            //2.获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t");

            //3.获取返回值类型
            System.out.print(m.getReturnType()+"\t");

            //4.获取方法名
            System.out.print(m.getName());
            System.out.print("(");

            //5.获取形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes==null||parameterTypes.length==0)){
                for (int i =0;i<parameterTypes.length;i++){
                    if(i==parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName()+" args_"+i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName()+" args_"+i+" , ");
                }
            }
            System.out.print(")");

            //获取抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();

            if(exceptionTypes.length>0){
                System.out.print("throws ");
                for(int i = 0 ; i<exceptionTypes.length;i++){
                    if(i==exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName()+" , ");
                }

            }
            System.out.println("");
        }


    }
}
