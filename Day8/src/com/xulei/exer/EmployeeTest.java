package com.xulei.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
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
        TreeSet<Employee> ste = new TreeSet(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                    MyDate birthday1 = o1.getBirthday();
                    MyDate birthday2 = o2.getBirthday();
                    return birthday1.compareTo(birthday2);
            }
        });

        Employee e1 = new Employee("hxl", 18, new MyDate(2001, 8, 02));
        Employee e2 = new Employee("xulei", 14, new MyDate(2002, 8, 02));
        Employee e3 = new Employee("nihao", 25, new MyDate(1997, 8, 02));
        Employee e4 = new Employee("cheng", 38, new MyDate(1987, 8, 02));
        Employee e5 = new Employee("aang", 17, new MyDate(2001, 8, 03));
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
        TreeSet<Employee> ste = new TreeSet<Employee>();

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


        Iterator<Employee> iterator = ste.iterator();

        while (iterator.hasNext()){
            Employee e = iterator.next();
            System.out.println(e);
        }
    }
}
