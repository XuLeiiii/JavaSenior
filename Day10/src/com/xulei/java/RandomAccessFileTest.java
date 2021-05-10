package com.xulei.java;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author xl
 * @Description:随机存取文件流
 * @date: 2021-05-10 23:31
 * @since JDK 1.8
 * RandomAccessFile的使用
 * * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * *
 * * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 * *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 * *
 * * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 */
public class RandomAccessFileTest {


    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("10.jpg"), "r");
            raf2 = new RandomAccessFile(new File("101.jpg"), "rw");
            //2.复制
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        //将指针调到指针为3的位置
        raf1.seek(new File("hello.txt").length());
        //覆盖的效果
        raf1.write("hxl".getBytes());
        raf1.close();

    }

    /**
     * 使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        //将指针调到指针为3的位置
        raf1.seek(3);
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));


        }
        //调回指针写入 xyz
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.write(buffer.toString().getBytes());

    }


}
