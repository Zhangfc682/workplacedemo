package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 22:23
 * @Modified By:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: MyInput
 * @Description
 * 自定义文件输入
 * @Author: Zhangfucai
 * @Date: 2021/4/9 22:23
 * @Version: 1.0
 */
public class MyInput {
    public static String input(){

        //System.in为字节输入流，需要转换为字符流
        InputStreamReader isr = new InputStreamReader(System.in);

        //使用字符处理流包装
        BufferedReader br = new BufferedReader(isr);
        String str = null;

        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

    public static int readInt(){
        return Integer.parseInt(input());
    }
    public static double readDouble(){
        return Double.parseDouble(input());
    }
    public static byte readByte(){
        return Byte.parseByte(input());
    }

    public static void main(String[] args){
        System.out.println(readInt());
    }
}
