package com.xulei.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口
 *      Callable接口方式的创建比Runnable接口强大
 *       call();可以有返回值，可以抛出异常
 *       Callable支持泛型
 *
 *
 * @author xl
 * @Description:
 * @date: 2021-04-23 20:20
 * @since JDK 1.8
 *
 *
 */
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumberThread num = new NumberThread();
        //4.将Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask=new FutureTask(num);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象并调用start()方法
        new Thread(futureTask).start();
        try {
            //get()返回值即为FutureTask构造器参数Callable的call方法返回值
            Object sum=futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 创建线程的方式三：实现Callable接口
 * 1.创建一个实现一Callable的实现类
 */
class NumberThread implements Callable {
    /**
     * 实现call方法，将此线程休要执行的操作声明在call放里面
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i %2==0){
                System.out.println(i);
                sum+=i;

            }
        }
        return sum;
    }
}

