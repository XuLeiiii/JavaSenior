package com.xulei.exer;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author xl
 * @ClassName: WordCountTest
 * @Description:
 * @date: 2021-05-10 16:34
 * @since JDK 1.8
 */
public class WordCountTest {

    @Test
    public void testWordCount() {
        Map<Character, Integer> map = null;
        FileReader fr = null;
        try {
            //1.创建Map集合 用于存储
            map = new HashMap<>();

            //2.遍历每一个字符，每一个字符出现的次数放到Map中
            fr = new FileReader("hello.txt");
            int c = 0;//用来
            while ((c = fr.read()) != -1) {
                //int 还原char
                char ch = (char) c;
                //判断char是否在map中第一次出现
                //如果get(ch)等于空说明第一次出现  进行新增
                if (map.get(ch) == null) {
                    //如果是出现第一次就添加进去   ch=存储出现的字符   value=1
                    map.put(ch, 1);
                } else {
                    //如果不是第一次增加  则修改value值加1   map.get(ch)取value的值
                    map.put(ch, map.get(ch) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        BufferedWriter bw = null;
        try {
            //3.把map中数据存在文件count.txt中
            //3.1创建Writer
            bw = new BufferedWriter(new FileWriter("count.txt"));
            //3.2遍历map,在写入数据
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> next = iterator.next();
                String arr = next.getKey() + "出现的次数:" + next.getValue();
                bw.write(arr + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
