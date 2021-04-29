package src.com.xulei.java;

/**
 * 多线程的创建方式一：继承于Thread
 * 1.创建一个继承于Thread类的子类
 * 2.重新thread类的run（）方法   将此线程执行的操作声明在run中
 * 3.创建thread类的子类
 * 4.通过此对象调用start():  1.启动当前线程 2.调用当前线程的run()方法
 *
 * @author xl
 * @ClassName: ThreadTest 多线程
 * @Description:
 * @date: 2021-04-21 11:36
 * @since JDK 1.8
 */
public class ThreadTest{
    public static void main(String[] args) {
        //3.创建Thread 子类对象
        MyThread t = new MyThread();
        //4.通过此对象调用start()
        t.start();//1.启动当前线程 2.调用当前线程的run()方法
        //t.run();//不能直接调用run()的方式启动线程
        MyThread t1 =new MyThread();
        //在创建一个线程
        t1.start();
        //如下操作在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2!= 0) {
                System.out.println("*"+i);
            }
        }
    }
}
//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重新thread类的run（）方法
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2== 0) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }

    }


}

