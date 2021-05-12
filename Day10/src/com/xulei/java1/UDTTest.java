package com.xulei.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author xl
 * @ClassName: UDTTest
 * @Description: UDT的往来编程
 * @date: 2021-05-12 16:59
 * @since JDK 1.8
 */
public class UDTTest {

    /**
     * 发送端
     */
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "UPd发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);
        socket.send(packet);

        socket.close();

    }


    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];


        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
    }
}


