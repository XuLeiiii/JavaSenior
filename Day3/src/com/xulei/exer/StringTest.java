package com.xulei.exer;
import org.junit.Test;
/**
 * @author xl
 * @Description:
 * @date: 2021-04-24 22:04
 * @since JDK 1.8
 */
public class StringTest {

    @Test
    public void test1(){
        String a="123";
        String b="123";
        String c = new String("123");
        String d = new String("123");
        //true
        System.out.println(a.equals(b));
        //true
        System.out.println(a==b);
        //true
        System.out.println(c.equals(d));
        //false
        System.out.println(c==d);
        //true
        System.out.println(a.equals(c));
        //false
        System.out.println(a==c);
    }

    @Test
    public void test(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        //4
        System.out.println(sb.length());
        //null
        System.out.println(sb);
        //异常
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
