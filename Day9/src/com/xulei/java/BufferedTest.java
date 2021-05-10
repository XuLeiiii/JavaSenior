package com.xulei.java;

import org.junit.Test;

import java.io.*;

/**
 * @author xl
 * @ClassName: BufferedTest
 * @Description: 缓冲流
 * @date: 2021-05-10 15:36
 * @since JDK 1.8
 * <p>
 * 1.缓冲流:
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.提供流的读取、写入速度
 * 提高速度的原因：内部提供了一个缓冲区
 * <p>
 * 3.处理流：就是“套接”在已有的流的基础上
 */
public class BufferedTest {


    /**
     * 实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File file1 = new File("10.JPG");
            File file2 = new File("14.JPG");
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制的细节：读取 写入
            //创建一个byte数组来接收
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            //要求：先关闭外层的流，关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //关闭外层流的同时，内层流会自动进行关闭，关于内层流的关闭可以省略
//        fos.close();
//        fis.close();

        }

    }

    /**
     * 实现文件复制的方法
     */
    public void copyFile(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File file1 = new File(srcPath);
            File file2 = new File(destPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制的细节：读取 写入
            //创建一个byte数组来接收
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {

                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            //要求：先关闭外层的流，关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭外层流的同时，内层流会自动进行关闭，关于内层流的关闭可以省略
//        fos.close();
//        fis.close();

        }
    }

    /**
     * 测试复制文件
     */
    @Test
    public void testCopyFile() {
        //获取当前时间
        long start = System.currentTimeMillis();
        String srcPath = "D:\\demo\\demo1.mp4";
        String destPath = "D:\\demo\\demo3.mp4";

        copyFile(srcPath, destPath);
        //获取当前时间
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为" + (end - start));//
    }

    /**
     * 使用BufferedReaderBufferedWriter处理复制
     */
    @Test
    public void testBufferedReaderBufferedWriter() throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello5.txt")));
            //读写操作
            //方式一
    /*        char[] buffer = new char[1024];
            int len;
            while((len=br.read(buffer))!=-1){
                bw.write(buffer,0,len);
            }*/
            //方式二：使用String  readLine()每次读取一行
            String data;
            while ((data=br.readLine())!=null){
                //方法一：手动换行
               // bw.write(data+"\n");//不包含换行符
                //方法二：自动换行
                bw.write(data);//不包含换行符
                //提供换行的操作
                bw.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
            if (br != null) {
                br.close();
            }
        }


    }
}
