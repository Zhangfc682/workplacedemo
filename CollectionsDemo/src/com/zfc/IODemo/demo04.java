package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 16:30
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @ClassName: demo04
 * @Description
 * 缓冲流（处理流）：提高流的读取、写入的速度。
 *      BufferedInputStream
 *      BufferedOutputStream
 *      BufferedReader
 *      BufferedWriter
 *
 *      关闭外层流的同时，内层流会自动进行关闭。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/9 16:30
 * @Version: 1.0
 */
public class demo04 {
    //实现图片加密操作
    @Test
    public void test(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //使用Buffered缓冲流包装节点流
            File srcFile = new File("001_copy.jpeg");
            File destFile = new File("001_jiami.jpeg");

            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] buffer = new byte[8];
            int len;  //len为读取到的字节数

            while ((len = bis.read(buffer))!=-1){
                //在写出之前，进行字节加密
                for (int i=0;i<len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        //获取文本上每个字符出现的次数：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中的数据写入文件
        File srcFile = new File("testChar.txt");
        BufferedReader br = null;
        BufferedWriter bw = null;
        Map<Character,Integer> map = new HashMap<>();
        int num;
        try {
            bw = new BufferedWriter(new FileWriter("result.txt"));
            br = new BufferedReader(new FileReader(srcFile));
            //遍历每一个字符
//            char[] cBuf = new char[8];
//            char data;
            int data;
            while ((data = br.read())!=-1) { //每次读取一个字符
                char c = (char) data;
                if (map.get(c) == null){
                    map.put(c,1);
                }else {
                    map.put(c,map.get(c) + 1);
                }
            }
            System.out.println(map);
//            List<String> list = new ArrayList<>();
//            Set<String> set = map.keySet();
            //遍历map，写入结果文件
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character,Integer> entry : entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格= " + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键= " + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车= " + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行 = " + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + " = " + entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
