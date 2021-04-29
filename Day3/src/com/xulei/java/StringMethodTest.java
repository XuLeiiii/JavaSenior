package com.xulei.java;

import org.junit.Test;

/**
 * String
 *
 * @author xl
 * @Description:
 * @date: 2021-04-24 16:32
 * @since JDK 1.8
 */
public class StringMethodTest {
    /**
     *  String replace(char oldChar, char newChar)：返回一个新的字符串，它是
     * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。  替换字符
     *  String replace(CharSequence target, CharSequence replacement)：使
     * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。  替换字符串
     *  String replaceAll(String regex, String replacement) ： 使 用 给 定 的
     * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     *  String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
     * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     * <p>
     * <p>
     *  boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     *  String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     *  String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
     * 字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */
    @Test
    public void test4() {
        String str1 = "北京尚硅谷教育北京";
        //替换指定字符
        String str2 = str1.replace('北', '东');
        System.out.println(str1);
        System.out.println(str2);
        //替换指定字符
        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);

        System.out.println("*****************************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        System.out.println("*****************************");
        /*
          告知此字符串是否匹配给定的正则表达式。
         */
        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);


        System.out.println("*****************************");
        /*
         根据给定正则表达式的匹配拆分此字符串。
         */
         str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
         str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }

    /**
     *  boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     *  boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     *  boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
     * 子字符串是否以指定前缀开始
     * <p>
     *  boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
     * 时，返回 true
     *  int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     *  int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
     * 现处的索引，从指定的索引开始
     *  int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     *  int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
     * 一次出现处的索引，从指定的索引开始反向搜索
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test3() {
        String str1 = "hello world";
        boolean ld = str1.endsWith("ld");//判断是否已这个字符串结尾  返回布尔类型
        System.out.println(ld);

        boolean he = str1.startsWith("he");//判断是否已这个字符串开头  返回布尔类型
        System.out.println(he);

        boolean ll = str1.startsWith("lla", 2);//判断从指定位置是否以这个字符穿开头
        System.out.println(ll);

        System.out.println(str1.contains("llo w"));//判断str1字符串是否包含llow

        System.out.println(str1.indexOf("ll"));//从头开始查找指定字符串返回第一次出现的索引位置

        System.out.println(str1.indexOf("l", 5));//从指定位置查询指定字符串返回出现第一次的位置

        System.out.println(str1.lastIndexOf("ll"));//从后往前找指定字符串索引位置，返回索引位置

    }


    /**
     *  int length()：返回字符串的长度： return value.length
     *  char charAt(int index)： 返回某索引处的字符return value[index]
     *  boolean isEmpty()：判断是否是空字符串：return value.length == 0
     *  String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
     *  String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
     *  String trim()：返回字符串的副本，忽略前导空白和尾部空白
     *  boolean equals(Object obj)：比较字符串的内容是否相同
     *  boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大
     * 小写
     *  String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
     *  int compareTo(String anotherString)：比较两个字符串的大小
     *  String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
     * beginIndex开始截取到最后的一个子字符串。
     *  String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
     * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     */
    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = new String("abd");
        System.out.println(s3.compareTo(s4));//涉及到字符串排序  比较大小


        String s5 = "北京尚硅谷教育";
        String s6 = s5.substring(2);//返回一个新字符串，从第2个索引位置开始截取
        System.out.println(s5);
        System.out.println(s6);

        String s7 = s5.substring(2, 5);//返回一个新字符串，从第2个索引位置开始截取  第5-1个结束
        System.out.println(s7);


    }


    @Test
    public void test1() {
        String s1 = "Hello World";
        System.out.println(s1.length());//返回字符串长度
        System.out.println(s1.charAt(0));//返回指定位置值
        System.out.println(s1.charAt(8));//返回指定位置值
        System.out.println(s1.charAt(5));//返回指定位置值
        System.out.println(s1.isEmpty());//判断是否为空的字符串
        String s2 = s1.toLowerCase();//转换为小写
        String s3 = s1.toUpperCase();//转换为大写
        System.out.println(s1);//s1不可变的
        System.out.println(s2);
        System.out.println(s3);

        String s4 = "   he llo  world  ";
        String s5 = s3.trim();//除去首尾空格
        System.out.println(s4);
        System.out.println(s5);

    }
}
