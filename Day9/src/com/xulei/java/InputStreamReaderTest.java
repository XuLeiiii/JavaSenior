package com.xulei.java;

import org.junit.Test;

import java.io.*;
import java.util.Currency;

/**
 * @author xl
 * @ClassName: InputStreamReaderTest
 * @Description: 转换流
 * @date: 2021-05-10 17:10
 * @since JDK 1.8
 * 1.属于字符流
 * InputStreamReader  将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter 将一个字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 * <p>
 * 3.解码：字节、字节数组--->字符数组、字符串
 * 编码：字符数组、字符串--->字节、字节数组
 * <p>
 * 4.字符集
 */
public class InputStreamReaderTest {
    /**
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("hello.txt");
        //InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集  转换流
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.println(str);
        }
        isr.close();
    }

    /**
     * 综合使用InputStreamReader
     */
    @Test
    public void test2() throws IOException {
        //造文件
        File file1 = new File("hello.txt");
        File file2 = new File("hello_gbk.txt");
        //造流
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        //转换流
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        //读写过程
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf,0,len);
        }
        //关闭资源
        osw.close();
        isr.close();
    }
}
