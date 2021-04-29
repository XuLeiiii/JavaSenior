package src.com.xulei.java;

/**
 * @author xl
 * @ClassName: windowTest1
 * @Description:
 * @date: 2021-04-21 17:09
 * @since JDK 1.8
 */
public class windowTest1 {
    public static void main(String[] args) {
        window1 w = new window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("线程一：");
        t2.setName("线程二：");
        t3.setName("线程三：");
        t1.start();
        t2.start();
        t3.start();
    }
}

class window1 implements Runnable{

    private  int ticket = 100;
    public void run(){
        while (true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票，票号为"+ticket);
                ticket--;

            }else{
                break;
            }
        }

    }
}
