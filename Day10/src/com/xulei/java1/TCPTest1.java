package com.xulei.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author xl
 * @ClassName: TCPTest1
 * @Description:使用TCP发送文件
 * @date: 2021-05-12 16:06
 * @since JDK 1.8
 */
public class TCPTest1 {

    @Test
    public void client() throws Exception {
        //1.创建Socket指定域名和端口
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2.获取输出流
        OutputStream os = socket.getOutputStream();
        //3.获取输入流
        FileInputStream fis = new FileInputStream(new File("10.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        //4.读取的数据
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        fis.close();
        os.close();
        socket.close();

    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            //创建服务器Socket
            ss = new ServerSocket(9090);
            //表示可以获取Socket
            socket = ss.accept();

            //获取输入流
            is = socket.getInputStream();
            //获取输出流
            os = new FileOutputStream(new File("d:\\demo\\10.jpg"));


            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            os.close();
            is.close();
            socket.close();
            ss.close();

        }




    }
}
