package com.xulei.java;

/**
 * 例子：创建三口窗口买票，总数一百张
 *
 * @author xl
 * @ClassName: windowTest
 * @Description:
 * @date: 2021-04-21 16:21
 * @since JDK 1.8
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 extends Thread {

    private static int ticket = 100;
    private static Object obj =new Object();
    @Override
    public void run() {
        while (true) {
                show();
        }

    }
    //同步方法
    public static synchronized void show(){//同步监视器：WindowTest4.class

        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}