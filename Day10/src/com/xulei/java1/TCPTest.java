package com.xulei.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author xl
 * @ClassName: TCPTest
 * @Description:实现TCP的网络编程
 * @date: 2021-05-12 15:33
 * @since JDK 1.8
 */
public class TCPTest {
    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("你好我是xl".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (os != null) {
                os.close();
            }
            if (socket != null) {
                socket.close();
            }

        }


    }

    /**
     * 服务器端
     */
    @Test
    public void server() {
        InputStream is = null;
        Socket s=null;
        ServerSocket ss=null;
        ByteArrayOutputStream baos=null;
        try {
            //1.创建服务器端的ServerSocket,指明自己的端口号
             ss = new ServerSocket(8899);
            //2.调用accept()表示接受来自于客户端socket
             s = ss.accept();
            //3.获取输入流
            is = s.getInputStream();

//            byte[]  buffer = new byte[1024];
//            int len;
//            while((len=is.read())!=-1){
//                String str =new String(buffer,0,len);
//                System.out.println(str);
//            }
            //4.读取输入流中的数据
             baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源

        }


    }

}
