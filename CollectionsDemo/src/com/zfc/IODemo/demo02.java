package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 13:01
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: demo02
 * @Description
 * IOStream:
 * 1.操作的数据单位：字节流（图片、视频）、字符流（文本文件）
 * 2.流向：输入流、输出流
 * 3.功能：节点流、处理流
 *
 * 抽象基类：
 * 输入流：InputStream（字节）、Reader（字符）
 * 输出流：OutputStream（字节）、Writer（字符）
 *
 * 节点流：（文件流）
 * 输入流：FileInputStream、FileReader
 * 输出流：FileOutputStream、FileWriter
 *
 * 处理流：（缓冲流）
 * 输入流：BufferedInputStream、BufferedReader
 * 输出流：BufferedOutputStream、BufferedWriter
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/9 13:01
 * @Version: 1.0
 */
public class demo02 {

    @Test
    public void test() throws IOException {
        File file = new File("hello.txt");  //相对于当前Module

        FileReader fileReader = new FileReader(file);

//        int data = fileReader.read();
//        while (data != -1){
//            System.out.print((char)data);  //每次读取一个字符
//            data = fileReader.read();
//        }

        int data1;
        while ((data1 = fileReader.read()) != -1){
            System.out.print((char) data1);
        }

        fileReader.close();
    }

    @Test
    public void test2(){
        FileReader fr = null;
        try{
            File file = new File("hello.txt");
            fr = new FileReader(file);

            int data;
            while ((data = fr.read()) != -1){
                System.out.print((char) data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        //读取指定长度的字符
        FileReader fr = null;
        try{
            File file = new File("hello.txt");
            fr = new FileReader(file);

            //设置读取指定长度的装载容器数组
            char[] cbuf = new char[3];
            int len;
//            fr.read(cbuf);

            while ((len = fr.read(cbuf)) != -1){
                //返回读取到的字符的长度，若到末尾则返回-1
//                for (int i=0;i<len;i++){
//                    System.out.print(cbuf[i]);
//                }
                  String str = new String(cbuf,0,len);
                  System.out.print(str);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4(){
        //文件写出:默认会覆盖原来存在的文件；若改为true，则表示在原来的文件中追加内容。
        FileWriter fw = null;
        try{
            File file = new File("hello1.txt");  //写出的文件若不存在，会自动创建
            fw = new FileWriter(file);

            fw.write("I have a dream!\n");
            fw.write("You love me!");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5(){
        //完成：从一个文件中读取内容，经过内存写入到另一个文件
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello.txt");  //源文件必须存在
            File destFile = new File("hello_1.txt");  //目标文件会自动创建

            //创建输入输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //进行读取然后写出
            char[] cBuf = new char[3];  //读取字符的装载容器
            int len;  //读取成功返回的字符数
            while ((len = fr.read(cBuf)) != -1){
                fw.write(cBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
