package com.xulei.exer;

import org.junit.Test;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-25 17:04
 * @since JDK 1.8
 */
public class StringDemo2 {

    public String getMaxSameString(String str1, String str2) {
        //获取长度长的字符串
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        //换取短的字符串
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length-i;y<=length ; x++,y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;

    }


    @Test
    public void test(){
        String st1="abcdeffferasererad";
        String str2="asdeqfff";
        String maxSameString = getMaxSameString(st1, str2);
        System.out.println(maxSameString);

    }

}
