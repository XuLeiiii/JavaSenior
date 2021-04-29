package src.com.xulei.java;

/**
 * 创建多线程方式二：实现Runnable接口
 *              1.创建一个实现Runnable接口
 *              2.实现类的中的抽象方法main
 *              3.创建实现类的对象
 *              4.将此对象作为参数Thread类的构造器中，创建Thread类的对象
 *              5.通过Thread类的对象调用start();
 *
 * 比较创建线程的两种方式
 *                开发中：优先选择：实现Runnable
 *                  原因：1.实现的方法没有类的单继承的局限性
 *                       2.实现的方式更适合来处理多个线程共享数据的情况
 *              联系：Thread 实现了Runnable
 *              相同点：两种方式都需要重写run()，将线程要执行的逻辑声明在run()中、
 * @author xl
 * @ClassName: ThreadTest1
 * @Description:
 * @date: 2021-04-21 16:52
 * @since JDK 1.8
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThreda  t= new MThreda();
        //4.将此对象作为参数通过Thread类的构造其中，创建Thread类的对象
        Thread t1=new Thread(t);
        //5.通过Thread类的对象调用start(); 启动线程， 调用当前线程的run()方法
        t1.setName("线程一：");
        t1.start();

        Thread t2=new Thread(t);
        t2.setName("线程二：");
        t2.start();
    }
}
//1.创建一个实现Runnable接口
class MThreda implements Runnable{

    //2.实现类的中的抽象方法main
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
}
