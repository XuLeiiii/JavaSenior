package com.xulei.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xl
 * @ClassName: TCPTest2
 * @Description:客户端发送图片给服务器端  服务器端接收保存，并返回接收成功到客户端输出
 * @date: 2021-05-12 16:30
 * @since JDK 1.8
 */
public class TCPTest2 {


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
        //关闭图片输出
        socket.shutdownOutput();
        //接受来自服务器的数据
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        byte[] buff = new byte[5];
        int len1;
        while ((len1=is.read(buff))!=-1){
            baos.write(buff,0,len1);
        }
        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        baos.close();
        is.close();

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
            os = new FileOutputStream(new File("d:\\demo\\101.jpg"));


            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //服务器端给客户端反馈
            OutputStream os1 = socket.getOutputStream();
            os1.write("照片已经收到".getBytes());
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
