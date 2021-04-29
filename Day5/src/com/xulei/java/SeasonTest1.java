package com.xulei.java;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-28 17:28
 * @since JDK 1.8
 *
 * * 常用方法：
 *  *  values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *  *  valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *  *  toString()：返回当前枚举类对象常量的
 */
public class SeasonTest1 {


    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println("**********************");
        //返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
        Season1[] values = Season1.values();
        for(Season1 s:values){
            System.out.println(s);
            s.show();
        }
        System.out.println("********************");

        //valueOf() 返回枚举类中对象名是Object类的对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}
interface Info{
    void show();


}


/**
 * enum方式定义枚举类
 */
enum Season1 implements Info{
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {

        }


    },
    SUMMER("夏天", "夏日炎炎"){

        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    SUTUMN("秋天", "秋高气爽"){

        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地"){

        @Override
        public void show() {
            System.out.println("冬天");
        }
    };


    private final String name;
    private final String desc;

    Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


}