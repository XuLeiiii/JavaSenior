package com.xulei.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-05 21:34
 * @since JDK 1.8
 */
public class EmployeeTest {


    @Test
    public void test2(){
        TreeSet ste = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee&&o2 instanceof Employee){
                    Employee e1= (Employee) o1;
                    Employee e2= (Employee) o2;

                    MyDate birthday1 = e1.getBirthday();
                    MyDate birthday2 = e2.getBirthday();
                    //比较年
//                    int minusYear= birthday1.getYear()-birthday2.getYear();
////                    if(minusYear!=0){
////                        return minusYear;
////                    }
////                    //比较月
////                    int minusMonth =birthday1.getMonth()-birthday2.getMonth();
////                    if(minusMonth!=0){
////                        return minusMonth;
////                    }
////                    //比较日
////                    return birthday1.getDay()-birthday2.getDay();
                    return birthday1.compareTo(birthday2);

                }

                throw new RuntimeException("传入的类型数据不一致");

            }
        });

        Employee e1 = new Employee("hxl", 18, new MyDate(2001, 8, 02));
        Employee e2 = new Employee("xulei", 14, new MyDate(2002, 8, 02));
        Employee e3 = new Employee("nihao", 25, new MyDate(1997, 8, 02));
        Employee e4 = new Employee("cheng", 38, new MyDate(1987, 8, 02));
        Employee e5 = new Employee("wang", 17, new MyDate(2001, 8, 03));
        ste.add(e1);
        ste.add(e2);
        ste.add(e3);
        ste.add(e4);
        ste.add(e5);


        Iterator iterator = ste.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



    /**
     * 使用自然排序
     */
    @Test
    public void test1() {
        TreeSet ste = new TreeSet();

        Employee e1 = new Employee("hxl", 18, new MyDate(2001, 8, 02));
        Employee e2 = new Employee("xulei", 14, new MyDate(2002, 8, 02));
        Employee e3 = new Employee("nihao", 25, new MyDate(1997, 8, 02));
        Employee e4 = new Employee("cheng", 38, new MyDate(1987, 8, 02));
        Employee e5 = new Employee("wang", 17, new MyDate(2001, 8, 03));

        ste.add(e1);
        ste.add(e2);
        ste.add(e3);
        ste.add(e4);
        ste.add(e5);


        Iterator iterator = ste.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
