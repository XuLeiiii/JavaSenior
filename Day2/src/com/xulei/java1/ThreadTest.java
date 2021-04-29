package com.xulei.java1;

/**
 * 演示死锁
 * @author xl
 * @Description:
 * @date: 2021-04-22 20:46
 * @since JDK 1.8
 */
public class ThreadTest {

    public static void main(String[] args){
        StringBuffer s1= new StringBuffer();
        StringBuffer s2= new StringBuffer();
        new Thread(){
            @Override
            public void run(){
                synchronized(s1){
                    s1.append("a");
                    s2.append("1");
                    try {
                        Thread.sleep(100);             //当线程一进入了到此  休眠100毫秒  锁死S1 就会去执行线程二
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }


        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2){
                    try {
                        Thread.sleep(100);     //当线程二执行到此 锁死S2
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s1.append("c");
                    s2.append("3");
                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
