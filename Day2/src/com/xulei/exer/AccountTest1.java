package com.xulei.exer;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-23 22:25
 * @since JDK 1.8
 */
public class AccountTest1 {
    public static void main(String[] args) {
        User account1 = new User();
        new Thread(account1).start();
        new Thread(account1).start();
    }
}


class Account1 {

    private  int money=0;
    public void drawMoney(int money){
            if(money>0){
                this.money+=money;
                System.out.println(Thread.currentThread().getName()+"余额为:"+this.money);
            }
    }
}


class  User implements Runnable{
    private Account1 account1 =new Account1();
    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account1.drawMoney(1000);
        }

    }
}