package com.xulei.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

/**
 * @author xl
 * @ClassName: InetAddressTest
 * @Description: 网络编程（Socket）   ip和端口号
 * @date: 2021-05-12 14:55
 * @since JDK 1.8
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //实例化   ip
            InetAddress inet1 = InetAddress.getByName("192.168.1.1");
            System.out.println(inet1);
            //实例化   域名
            InetAddress inet2 = InetAddress.getByName("www.xulei.cc");
            System.out.println(inet2);
            //获取本地IP
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
            //常用方法
            //getHostName()  获取域名
            System.out.println(inet2.getHostName());
            //getHostAddress()  获取IP地址
            System.out.println(inet2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
