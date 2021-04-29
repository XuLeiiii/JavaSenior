package com.xulei.java1;

/**
 * 使用同步机制将单例模式中的懒汉模式改为线程安全的
 *
 * @author xl
 * @Description:
 * @date: 2021-04-22 20:22
 * @since JDK 1.8
 */
public class BanTest {
}

/**
 * @Description: 单例模式懒汉模式线程安全的
 */
class Bank {

    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {//锁是：Bank.class
        //方式一：效率不高
//        synchronized(Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }


}