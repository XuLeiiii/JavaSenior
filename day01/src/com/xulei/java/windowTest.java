package src.com.xulei.java;

/**
 * 例子：创建三口窗口买票，总数一百张
 *  存在线程安全问题
 * @author xl
 * @ClassName: windowTest
 * @Description:
 * @date: 2021-04-21 16:21
 * @since JDK 1.8
 */
public class windowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }
}
class Window extends Thread {

    private static int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}