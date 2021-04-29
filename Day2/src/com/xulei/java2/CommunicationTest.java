package com.xulei.java2;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-22 22:04
 * @since JDK 1.8
 * 交替输出
 * 涉及到的方法
 *  wait();一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 *  notify();会唤醒一个wait的一个线程
 *  notifyAll();会唤醒所有wait的线程
 *  这三个方法必须使用在synchronized代码块或方法中
 *  这三个方法必须是同步代码块或同步方法中的同步监视器调用
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread  t1= new Thread(n);
        Thread  t2= new Thread(n);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();

    }
}

class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                //唤醒一个      notifyAll();唤醒所有线程
                notify();
                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        //使得调用该方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
