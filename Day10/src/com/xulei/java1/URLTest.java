package com.xulei.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author xl
 * @ClassName: URLTest
 * @Description:  ur的测试
 * @date: 2021-05-12 17:12
 * @since JDK 1.8
 */
public class URLTest {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/examples/beauty.jpg?usetname=tom");
        //获取该url的协议名
        System.out.println(url.getProtocol());
        //获取url的主机名
        System.out.println(url.getHost());
        //获取url的端口号
        System.out.println(url.getPort());
        //获取url的路径
        System.out.println(url.getPath());
        //获取url的文件名
        System.out.println(url.getFile());
        //获取url的查询名
        System.out.println(url.getQuery());
    }
}
