package com.xulei.exer;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-23 22:06
 * @since JDK 1.8
 */
public class ThreadTest {
    public static void main(String[] args) {
        Number number = new Number();
        Number1 number1 = new Number1();

        FutureTask task=new FutureTask(number1);
        new Thread(number).start();
        new Thread(task).start();


    }
}


class Number implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println("偶数"+i);
            }
        }
    }
}

class Number1 implements Callable {


    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println("奇数"+i);
            }
        }
        return null;
    }
}