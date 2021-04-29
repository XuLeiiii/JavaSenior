package src.com.xulei.java;

/**
 * 常用方法：
 * 1.start();启动线程，调用当前线程run()方法
 * 2.run();通常需要重新Thread类中的此方法，将需要执行的声明代码写在里面
 * 3.currentThread();静态方法，返回执行当前代码的线程
 * 4.getName();获取当前线程名字
 * 5.setName():设置当前线程名字
 * 6.yield();  释放当前CPU的执行权，
 * 7.join();在线程A中调用线程B的join(),此线程a就进入阻塞状态，知道线程B完全执行完以后，线程a才结束阻塞状态
 * 8.stop()；强制结束当前线程  不建议使用
 * 9.sleep(LONG );  让当前线程睡眠指定的毫秒数，当前线程是阻塞状态
 * 10.isAlive();判断当前线程是否还存活
 *
 * 线程的优先级：
 *              getPriority();获取当前优先级
 *              setPriority();设置当前优先级
 *
 *              说明：高优先级的线程要抢占底优先级的CUP的线程，但是只是从概率上讲
 *
 * @author xl
 * @ClassName: ThreadMethodTest
 * @Description:
 * @date: 2021-04-21 14:20
 * @since JDK 1.8
 */
public class ThreadMethodTest {
    public static void main(String[] args)  {
        MyThread1 m1 = new MyThread1();
        //设置线程的优先级
        m1.setPriority(10);

        //给m1线程命名
        m1.setName("线程一:");
        //启动线程，调用当前线程run()方法
        m1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程：");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority()+"  "+i);
            }
            if(i==20){
//                try {
//                    m1.join();//在线程A中调用线程B的join(),此线程a就进入阻塞状态，知道线程B完全执行完以后，线程a才结束阻塞状态
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
        System.out.println(m1.isAlive());;//判断当前进程是否存放

    }
}

class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(10);//让当前线程睡眠指定的毫秒数，当前线程是阻塞状态
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() +getPriority()+" "+ i);
            }
            if (i % 20 == 0) {
                this.yield();
            }
        }
    }
}
