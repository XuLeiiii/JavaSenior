package com.xulei.exer;


import org.junit.Test;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-25 16:03
 * @since JDK 1.8
 */
public class StringDemo {


    /**
     * 将指定字符串部分内容进行反转
     * <p>
     * 方式一：转换为char数组
     *
     * @param str   字符串
     * @param start 从那个位置开始
     * @param end   那个位置结束
     * @return 返回反转后的字符串
     */
    public String reverse(String str, int start, int end) {
        if (str != null && str != "") {
            //转换为char数组
            char[] arr = str.toCharArray();
            //x开头  y结束 ，结束后X加一   Y减一   X不能大于Y
            for (int x = start, y = end; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    /**
     * 第二种方式  通过方法来
     * @param str
     * @param star
     * @param end
     * @return
     */
    public String reverse1(String str, int star, int end) {
        if (str != null){
            //第一部分取出不需要反转的   substring截取指定位置
            String reverseSet=str.substring(0,star);
            //第二部分把需要反转的位置从结尾循环拼接在不变的部分
            for (int i = end; i >=star; i--) {
                //charAt取指定位置字符
                reverseSet+=str.charAt(i);
            }
            //第三部分  不后面不变的部分拼接上
            reverseSet+=str.substring(end+1);
            return reverseSet;
        }
        return null;
    }

    /**
     * 第三方式 使用StringBuilder或者StringBuffer
     * @param str
     * @param star
     * @param end
     * @return
     */
    public String reverse2(String str, int star, int end) {
        StringBuilder sb1= new StringBuilder(str.length());
        //第一部分 获取开头不变的部分
        sb1.append(str.substring(0,star));
        //第二部分 反转需要变换的部分 并拼接
        for (int i = end; i >=star ; i--) {
            sb1.append(str.charAt(i));
        }
        //第三部分 拼接结尾不变的部分
        sb1.append(str.substring(end+1));
        return sb1.toString();
    }


    @Test
    public void testReverse() {
        String str = "abcde";
        String str1 = reverse2(str, 2, 4);
        System.out.println(str);
        System.out.println(str1);
    }


}
