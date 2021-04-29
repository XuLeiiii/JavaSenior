package com.xulei.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁  ---jdk5.0
 *
 * 1.面试提
 *        synchronized 与Lock的异同
 *        同：都可以解决线程安全问题
 *        不同：synchronized 机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动启动（lock()），同时结束同步也需要手动结束（unlock()）
 * @author xl
 * @Description:
 * @date: 2021-04-22 21:10
 * @since JDK 1.8
 */
public class  LockTest {
    public static  void main(String[] args) {
        Window w= new Window();
       Thread t1= new Thread(w);
       Thread t2= new Thread(w);
       Thread t3 =new Thread(w);
       t1.setName("窗口一：");
       t2.setName("窗口二：");
       t3.setName("窗口三：");
       t1.start();
       t2.start();
       t3.start();
    }
}

class Window implements Runnable{
    private int ticket = 100;
    /**
     *  1.实例化ReentrantLock
     */
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public  void  run() {
        while (true){

              //2调用lock方法  调用锁定方法
            lock.lock();
            try{
              if(ticket>0){
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+"售票，票号为："+ ticket);
                  ticket--;
              }else {
                  break;
              }
          }finally {
              //3调用解锁的方法  unlock
              lock.unlock();
          }

        }
    }
}
