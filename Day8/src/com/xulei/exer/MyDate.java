package com.xulei.exer;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-05 21:31
 * @since JDK 1.8
 */
public class MyDate implements Comparable<MyDate>{

    private int year;

    private int month;

    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public MyDate() {
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        MyDate myDate = (MyDate) o;

        if (year != myDate.year) {return false;}
        if (month != myDate.month){ return false;}
        return day == myDate.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }


    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate m) {

            //比较年
            int minusYear= this.getYear()-m.getYear();
            if(minusYear!=0){
                return minusYear;
            }
            //比较月
            int minusMonth =this.getMonth()-m.getMonth();
            if(minusMonth!=0){
                return minusMonth;
            }
            //比较日
            return this.getDay()-m.getDay();

    }

//    @Override
//    public int compareTo(Object o) {
//
//        if(o instanceof MyDate){
//            MyDate m = (MyDate)o;
//
//            //比较年
//            int minusYear= this.getYear()-m.getYear();
//            if(minusYear!=0){
//                return minusYear;
//            }
//            //比较月
//            int minusMonth =this.getMonth()-m.getMonth();
//            if(minusMonth!=0){
//                return minusMonth;
//            }
//            //比较日
//            return this.getDay()-m.getDay();
//        }
//        throw new RuntimeException("传入的类型有误");
//    }
}
