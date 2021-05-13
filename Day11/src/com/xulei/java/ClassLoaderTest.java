package com.xulei.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-12 22:41
 * @since JDK 1.8
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

    }

    /**
     * 读取配置文件
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {

        Properties pros = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //读取的配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);
        String user = pros.getProperty("user");
        String pwd = pros.getProperty("pwd");
        System.out.println(user);
        System.out.println(pwd);

    }

}
