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
public class WindowTest3 {
    public static void main(String[] args) {
        window3 w = new window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");
        t1.start();
        t2.start();
        t3.start();
    }
}

class window3 implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
                show();
        }
    }
    //同步方法
    private synchronized void show(){//同步监视器：this
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
        }
    }
}