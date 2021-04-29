package com.xulei.exer;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-22 22:30
 * @since JDK 1.8
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk =new Clerk();
        Producer p1 =new Producer(clerk);
        Consumer c1= new Consumer(clerk);
        Consumer c2= new Consumer(clerk);
        p1.setName("生产者一");
        c1.setName("消费者一");
        c2.setName("消费者二");
        p1.start();
        c1.start();
        c2.start();
    }

}
class Clerk{

    private  int number=0;
    /**
     *   生成产品
     */
    public synchronized void produceProduct() {
        if(number<20){
            number++;
            System.out.println(Thread.currentThread().getName()+":开始生成第"+number+"个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     *  消费产品
     */

    public synchronized void consumerProduct() {
        if(number>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+number+"个产品");
            number--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer extends Thread{  //生产者
    private Clerk clerkl;

    public Producer(Clerk clerkl) {
        this.clerkl = clerkl;
    }
    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品....");
        while (true){
            clerkl.produceProduct();
        }
    }
}


class Consumer extends Thread{  //消费者
    private Clerk clerkl;

    public Consumer(Clerk clerkl) {
        this.clerkl = clerkl;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品....");
        while (true){
            clerkl.consumerProduct();
        }
    }
}