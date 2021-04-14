package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 22:14
 * @Modified By:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: demo06
 * @Description 获取键盘输入然后转换为大写输出
 * @Author: Zhangfucai
 * @Date: 2021/4/9 22:14
 * @Version: 1.0
 */
public class demo06 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true){
            String str = br.readLine();
            if ("e".equals(str) || "exit".equals(str)){
                System.out.println("程序结束");
                break;
            }
            System.out.println(str.toUpperCase());
        }
    }
}
