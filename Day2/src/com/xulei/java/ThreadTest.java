package com.xulei.java;

/**
 *
 * 1.买票过程中出现重票和错票————>出现了线程安全问题
 * 2.当某个线程操作车票的过程中，尚未操作完成，线程二进入执行了也操作了车票
 * 3.当一个线程在操作车票的时候，其他线程不能参与进来，知道线程A操作完成后其他线程才能开始操作
 * 4.在java中我们通过同步机制来解决线程问题
 *      方式一：同步代码块
 *          synchronized(同步监视器){
 *              //需要被同步的代码
 *          }
 *          说明：1.操作共享数据的代码，即为需要被同步的代码
 *               2.共享数据：多个线程共同操作的变量
 *              3.同步监视器（锁）任何一个类的对象，都可以充当锁
 *                       要求：多个线程必须要共用同一把锁
 *      方式二：同步方法
 *
 * 5.同步的方式，解决了线程的安全问题 ---好处
 *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程过程，效率低
 * @ClassName: ThreadTest
 * @Description:
 * @date: 2021-04-21 22:38
 * @author xl
 * @since JDK 1.8
 * @version v2.0
 */
public class ThreadTest  {
    public static void main(String[] args) {
        window w = new window();
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
class window implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            //同步代码块
            //多个线程必须要共用同一把锁
            synchronized (this){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖票，票号为："+ticket);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                }else{
                    break;
                }
            }

        }
    }
}