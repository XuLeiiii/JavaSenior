package com.xulei.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xl
 * @ClassName: PicTest
 * @Description:
 * @date: 2021-05-10 16:23
 * @since JDK 1.8
 */
public class PicTest {
    /**
     * 图片的加密
     * @throws FileNotFoundException
     */
    @Test
    public void test1()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建流
            fis = new FileInputStream("10.jpg");
            fos = new FileOutputStream("10secret.jpg");
            byte[] buffer= new byte[20];
            int len;
            while((len=fis.read(buffer))!=-1){
                //字节数据进行修改
                for (int i = 0; i < len; i++) {
                    buffer[i]=(byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 图片的解密
     * @throws FileNotFoundException
     */
    @Test
    public void test2()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建流
            fis = new FileInputStream("10secret.jpg");
            fos = new FileOutputStream("15.jpg");
            byte[] buffer= new byte[20];
            int len;
            while((len=fis.read(buffer))!=-1){
                //字节数据进行修改
                for (int i = 0; i < len; i++) {
                    buffer[i]=(byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
