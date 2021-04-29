package com.xulei.java;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-25 21:50
 * @since JDK 1.8
 */
public class Goods implements Comparable{

    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof  Goods){
            Goods goods= (Goods) o;
            if(this.price>goods.price){
                return 1;
            }else if(this.price<goods.price){
                return -1;
            }else{
                //return 0;
                return this.name.compareTo(goods.name);
            }
        }
        return 0;
    }



    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
