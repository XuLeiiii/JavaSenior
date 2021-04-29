package com.xulei.exer;

import org.junit.Test;

/**
 * @author xl
 * @Description:
 * @date: 2021-04-25 16:41
 * @since JDK 1.8
 */
public class StringDemo1 {

    /**
     * 获取主字符串包含字符串出现了几次
     *
     * @param mainStr 主字符串
     * @param subStr  子字符串
     * @return 返回次数
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index=0;
        if (mainLength >= subLength) {
            //方式一
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr=mainStr.substring(index+subLength);
//            }
            while ((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index+=subLength;

            }
            return count;
        } else {
            return 0;
        }
    }

    @Test
    public void test(){
        String str="sadaasdasaadasdaweqweqwaaeqweqwasdsaasa";
        String subStr="aa";
        int count = getCount(str, subStr);
        System.out.println(count);
    }
}
