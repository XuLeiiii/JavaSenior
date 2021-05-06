package com.xulei.exer2;

import java.util.*;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-06 21:43
 * @since JDK 1.8
 */
public class exerTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入十个数字");
        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            int j =scanner.nextInt();
            list.add(j);
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Integer && o2 instanceof Integer){
                    int i = (int) o1;
                    int j = (int) o2;
                    return  -Integer.compare(i,j);
                }
                return 0;
            }
        });
        System.out.println(list);
    }
}
