package com.xulei.java;
/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 */

import org.junit.Test;

import java.io.*;

/**
 * @author xl
 * @Description: 流的分类
 * @date: 2021-05-09 14:02
 * @since JDK 1.8
 */
public class FileReaderWriterTest {

    /**
     * 将day9下的hello.txt文件内容读入程序中，并输出到控制台
     * <p>
     * 说明点：
     * 1.read();返回读入的一个字符。如果达到文件末尾，返回-1
     * 2.异常的处理：为了保证流的一定可以执行关闭流，需要用try -catch-finally处理
     * 3.读入的文件一定要存在，否则就会报FileNotFoundException
     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //相对地址：相较于当前Module下
            //1.实例化File类的对象，指明要操作的对象
            File file = new File("hello1.txt");
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read();返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data=fr.read();
//        }
            //方式二：语法上针对方式一的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //流的关闭操作
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //返回每次读入char数组中的字符的个数。如果到达末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {

                //方式一：
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //方式二
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4.资源关闭
    }


    /**
     * 数据的写出：从内存中写出到数据的硬盘的文件里
     * 说明：
     *      1.输出操作，对应的File可以不存在,并不会报异常
     *          如果不存在，再输出的过程中，会自动创建此文件。
     *          如果存在：
     *              如果流使用的构造器是：FileWriter(file,false)/FIleWriter(file);对原有文件的覆盖
     *              如果流使用的构造器是：FileWriter(file,true);对原文件的追加
     */
    @Test
    public void testFileWriter() throws IOException {
        //1.提供File类的对象
        File file =new File("hello1.tx");

        //2.提供个FileWriter的对象，用于数据写出
        FileWriter fw = new FileWriter(file,true);

        //3.写出的操作
        fw.write("I have a  dream!!\n");
        fw.write("you need to have a dream!");

        //4.流资源关闭
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的想，指明读入和写出的文件
            //不能使用字符流操作图片和视频等
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cubf = new char[5];
            int len;//纪律每次读入到cubf数组中的字符个数
            while ((len=fr.read(cubf))!=-1){
                //每次写出len个字符
                fw.write(cubf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testFileInputStream()  {
        FileInputStream  fis = null;
        FileOutputStream fot = null;
        try {
            //1.创建File类实例
            File  file = new File("10.jpg");

            //2.创建字节流
            fis = new FileInputStream("10.jpg");

            fot = new FileOutputStream("11.jpg");


            //3.数据的读入和输出
            byte[] b = new byte[10];
            int len;

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

}