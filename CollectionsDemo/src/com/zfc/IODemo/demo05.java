package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 20:55
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: demo05
 * @Description
 * 转换流：提供了在字节流和字符流之间的转换。
 * InputStreamReader：将InputStream转换为Reader。
 * OutputStreamWriter：将Writer转换为OutputStream。
 *
 * 使用转换流来处理文件乱码问题。实现编码和解码的功能。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/9 20:55
 * @Version: 1.0
 */
public class demo05 {
    @Test
    public void test(){
        //处理字符文件时，使用的是字节流，可以将字节流通过转换流转换为字符流
        File file = new File("testChar.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;

        FileOutputStream fos = null;  //将字节输出流转换字符输出流
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"UTF-8");

            fos = new FileOutputStream("GBK_demo.txt");
            osw = new OutputStreamWriter(fos,"GBK");

            char[] cBuf = new char[20];
            int len;
            while ((len = isr.read(cBuf))!=-1){
                osw.write(cBuf,0,len);
                String str = new String(cBuf,0,len);
                System.out.print(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
