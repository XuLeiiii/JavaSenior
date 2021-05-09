package com.xulei.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author xl
 * @Description:
 * @date: 2021-05-07 22:03
 * @since JDK 1.8
 */
public class FileDemo {


    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\hello.txt");
        //创建一个与file同目录下 的另一个文件  名为：hi.txt
        //getParent()获取上层文件目录路径
        File file1 = new File(file.getParent(),"hi.txt");
        //createNewFile()创建文件。若文件存在，则不创建，返回false
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }
    }
}
