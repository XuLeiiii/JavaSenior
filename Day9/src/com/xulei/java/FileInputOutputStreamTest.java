package com.xulei.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-09 15:32
 * @since JDK 1.8
 *
 *
 *
 */
public class FileInputOutputStreamTest {

    /**
     * 处理文本文件可能出现乱码
     */
    @Test
    public void testFileInputStream()  {
        FileInputStream fis = null;
        try {
            //造文件
            File file  = new File("hello.txt");

            //造流
            fis = new FileInputStream(file);

            //读数据
            byte[] b = new byte[10];

            int len;//记录每次读取的字节的个数
            while ((len = fis.read(b))!=-1){

                    String str = new String(b,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileInputStream1()  {
        FileInputStream  fis = null;
        FileOutputStream fot = null;
        try {
            //1.创建File类实例
            File  file = new File("10.jpg");
            //2.创建字节流
            fis = new FileInputStream(file);
            fot = new FileOutputStream("11.jpg");
            //3.数据的读入和输出   复制的过程
            byte[] b = new byte[10];
            int len;//记录每次读取的个数
            while ((len=fis.read(b))!=-1){
                fot.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fot.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void copyFile(){



    }

}
