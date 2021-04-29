package com.xulei.exer;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-23 23:06
 * @since JDK 1.8
 */
public class WithDrawThreadTest {
    public static void main(String[] args) {
        Account2 account= new Account2("1234567", 10000);
        Thread t1 = new WithDrawThread("小明", account, 8000);
        Thread t2 = new WithDrawThread("小明's wife", account, 2800);
        t1.start();
        t2.start();
    }
}
class  WithDrawThread extends Thread{
    private Account2  acc;

    private double withDraw;

    public WithDrawThread(String name,Account2 acc,double amt) {
        super(name);
        this.acc=acc;
        this.withDraw=amt;
    }

    @Override
    public void run(){

        synchronized(acc){
            if(acc.getBalance()>=withDraw){
                System.out.println(Thread.currentThread().getName()+"取款成功，取现金额为"+withDraw);
                acc.setBalance(acc.getBalance()-withDraw);
            }else{
                System.out.println("余额不足");
            }
            System.out.println("现在余额为"+acc.getBalance());
        }

    }
}
class Account2 {
    private String accountId;
    private double balance;

    public Account2(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getName() {
        return accountId;
    }

    public Account2() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Account2 other = (Account2) obj;
        if (accountId == null) {
            if (other.accountId != null) {
                return false;
            }
        } else if (!accountId.equals(other.accountId)) {
            return false;
        }
        if (Double.doubleToLongBits(balance) !=
                Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return true;


    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 :
                accountId.hashCode());
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>>
                32));
        return result;
    }
}