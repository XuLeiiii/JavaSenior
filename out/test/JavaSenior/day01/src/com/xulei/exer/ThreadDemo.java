package src.com.xulei.exer;

/**
 * 创建两个分线程  一个遍历偶数  一个遍历
 * @author xl
 * @ClassName: TheradDemo
 * @Description:
 * @date: 2021-04-21 11:57
 * @since JDK 1.8
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread   t =new MyThread();
//        MyThread1 t1  =new MyThread1();
//        t.start();
//        t1.start();

        //创建匿名子类
        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+"  "+i);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){

                for (int i = 0; i < 100; i++) {
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+"  "+i);
                    }
                }
            }
        }.start();
    }
}

class MyThread extends Thread{

    public void run(){

        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
        }
    }



}


class MyThread1 extends Thread{
    public void run(){

        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
        }
    }

}