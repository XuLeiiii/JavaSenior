package com.xulei.exer;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-23 22:38
 * @since JDK 1.8
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        number number = new number();
        new Thread(number).start();
        new Thread(number).start();
    }
}


class  number implements Runnable{
    int i =1;
    @Override
    public synchronized void run() {

        while (true){

                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }


    }
}

