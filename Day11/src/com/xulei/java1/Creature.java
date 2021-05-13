package com.xulei.java1;

import java.io.Serializable;

/**
 * @author xl
 * @ClassName: Creature
 * @Description:
 * @date: 2021-05-13 14:53
 * @since JDK 1.8
 */
public class Creature<t> implements Serializable {
    private char gender;

    public double weight;


    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }


}
