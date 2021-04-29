package com.xulei.exer;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-22 21:32
 * @since JDK 1.8
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account();
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("xulei");
        c2.setName("xulei2");
        c1.start();
        c2.start();


    }

}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            acct.SaveMoney(1000);
        }


    }


}


class Account {
    private int balance = 0;

    public void SaveMoney(int money) {
        if (money > 0) {
            synchronized (this)
            {
                {
                    balance += money;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "余额为" + balance);
                }
            }

        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}