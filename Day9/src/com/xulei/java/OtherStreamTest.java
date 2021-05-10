package com.xulei.java;

import org.junit.Test;

import java.io.*;

/**
 * @author xl
 * @Description: 其他流的使用
 * @date: 2021-05-10 21:37
 * @since JDK 1.8
 */
public class OtherStreamTest {
    /**
     * 1.标准的到输入、输出流
     * 1.1
     * System.in:标准的输入流，默认从键盘输入
     * System.out:标准的数出流，从控制台输出
     * 1.2
     * System类的setIn（InputStream is ） /setOut(PrintStream ps)方式重新指定输入和输出的方法
     */

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串");
                String data = br.readLine();
                if (data.equalsIgnoreCase("e") || data.equalsIgnoreCase("exit")) {
                    System.out.println("程序退出");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 输出流
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("d:\\io\\text.txt"));
            //创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时都会刷新出缓冲区）
            ps = new PrintStream(fos, true);
            if (ps != null) {
                System.setOut(ps);
            }
            //输出ASCII字符
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                //每50个数据换行
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
        }

    }


    /**
     *数据流
     * DataInputStream 和DataOutputStream
     * 作用：用于读取或写出基本数据类型的变量和字符串
     *
     * 练习：将内存中过的字符串，基本数据类型的变量写出到文件中
     */

    @Test
    public void test3(){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("d:\\io\\hxl.txt"));
            dos.writeUTF("何小玲");
            dos.flush();//刷新操作，将内存中过的数据写入文件
            dos.writeInt(18);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 注意点：读取不同类型的数据的顺序要按照当初写入文件时，保存的数据顺序一致
     */
    @Test
    public void test4(){
        DataInputStream dis=null ;
        try {
            dis =new DataInputStream(new FileInputStream("d:\\io\\hxl.txt"));
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean b = dis.readBoolean();
            System.out.println("name:"+name);
            System.out.println("age:"+age);
            System.out.println("age:"+b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dis!=null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
