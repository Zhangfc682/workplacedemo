package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 11:39
 * @Modified By:
 */

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ClassName: demo07
 * @Description
 * RandomAccessFile:随机访问类
 * 直接继承与Object类，实现了DataInput和DataOutput接口，既可以作为一个输入流，又可以作为一个输出流。
 *
 * 作为文件输出流时，会对原有文件内容进行覆盖，默认情况下从头覆盖
 *
 * 支持“随机访问”的方式，程序可以跳到文件的任意地方来读、写。包含一个记录指针，用以标识当前读写处的位置。
 * 类对象可以自由移动记录指针。
 * long getFilePointer():获取文件记录指针的当前位置。
 * void seek(long pos):将文件记录指针定位到pos位置。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 11:39
 * @Version: 1.0
 */
public class demo07 {
    @Test
    public void test(){
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile(new File("001_copy.jpeg"),"r");
            raf1 = new RandomAccessFile(new File("001_ccc.jpeg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf.read(buffer)) != -1){
                raf1.write(buffer,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        //实现插入效果：先将待插入位置后面的字符读取出来并存储，然后于插入位置插入指定内容，再将存储的内容追加到指定内容之后
        RandomAccessFile raf = new RandomAccessFile(new File("test.txt"),"rw");

        StringBuilder sb = new StringBuilder((int) new File("test.txt").length());

        raf.seek(3);  //移动指针
        byte[] buffer = new byte[10];  //读取到的数据格式为字节类型，存入String中时需要进行转换
        int len;
        while ((len = raf.read(buffer)) != -1){
            String str = new String(buffer,0,len);
            sb.append(str);
        }

        raf.seek(3);
        raf.write("zzz".getBytes());  //写入时的格式同样为字节
        raf.write(sb.toString().getBytes());

        raf.close();
    }

    @Test
    public void test3(){
        //第三方jar包操作文件
        try {
            FileUtils.copyFile(new File("hello.txt"),new File("hello_copy.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
