package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 22:35
 * @Modified By:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @ClassName: printStreamDemo
 * @Description 打印流
 * @Author: Zhangfucai
 * @Date: 2021/4/9 22:35
 * @Version: 1.0
 */
public class printStreamDemo {
    public static void main(String[] args){
        PrintStream ps = null;

        try {
            FileOutputStream fos = new FileOutputStream(new File("char.txt")); //main函数中的相对路径为工程

            ps = new PrintStream(fos);  //输出流，指定输出的目的地
            if (ps!=null){
                System.setOut(ps);
            }

            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i%50==0){
                    System.out.println();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ps!=null){
                ps.close();
            }
        }
    }
}
