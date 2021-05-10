package com.xulei.java;

import org.junit.Test;

import java.io.*;

/**
 * @author xl
 * @Description:  对象流
 * @date: 2021-05-10 23:06
 * @since JDK 1.8
 * 要想一个java对象需要那些要求
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * ObjectOutputStream
     */

    @Test
    public void test1()  {
        ObjectOutputStream  oos = null;
        try {

            oos = new ObjectOutputStream(new FileOutputStream("string.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作
            oos.writeObject(new Person("何小玲",18));
            oos.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
     * 使用ObjectInputStream
     */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("string.dat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            Person person= (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
