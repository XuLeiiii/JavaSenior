package com.xulei.java2;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-06 21:14
 * @since JDK 1.8
 */
public class PropertiesTest {
    /**
     * properties 用来处理配置文件
     */
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name:"+name +"  密码："+password);
        fis.close();
    }
}
