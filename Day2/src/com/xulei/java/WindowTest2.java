package com.xulei.java;

/**
 * 例子：创建三口窗口买票，总数一百张
 * 存在线程安全问题
 *
 * @author xl
 * @ClassName: windowTest
 * @Description:
 * @date: 2021-04-21 16:21
 * @since JDK 1.8
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window2 extends Thread {

    private static int ticket = 100;
    private static Object obj =new Object();
    public void run() {
        while (true) {
            //同步代码块
            synchronized (Window2.class) {
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}