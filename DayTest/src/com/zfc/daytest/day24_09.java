package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 09:04
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: day24_09
 * @Description
 * 1.说明流的三种分类方式。
 * 节点流：直接使用在数据传输的终点与内存空间。
 * 处理流：套接在节点流之上的数据流，目的是加快数据的传输速度。
 * 转换流：将字符流转换为字节流，字节流转换为字符流。
 *
 *  流向：输入流、输出流
 *  数据单位：字节流、字符流
 *  流的角色：节点流、处理流
 *
 * 2.写出4个IO流中的抽象基类，4个文件流，4个缓冲流。
 * 基类：InputStream,OutputStream,Reader,Writer
 * 文件流：
 *      字节流：FileInputStream,FileOutputStream
 *      字符流：FIleReader,FileWriter
 * 缓冲流：
 *      字节流：BufferedInputStream,BufferedOutputStream
 *      字符流：BufferedReader,BufferedWriter
 *
 * 3.字节流与字符流的区别与使用情景。
 * 字节流：用于处理非文本文件，如图像、视频等。
 * 字符流：用于处理文本文件，处理一个个字符。
 *
 * 4.使用缓冲流实现a.jpg文件复制为b.jpg文件的操作。
 *
 * 5.转换流是哪两个类，分别的作用是什么？请分别创建两个类的对象。
 * 转换流：InputStreamReader:输入流，将字节转换为字符
 *        OutputStreamWriter:输出流，将字符流转换为字节
 *
 * 6.对象流：存储和读取基本数据类型或对象的处理流。强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 序列化：用ObjectOutputStream类保存基本数据类型或对象的机制。
 * 反序列化：用ObjectInputStream类读取基本数据类型或对象的机制。
 *
 * 不能序列化static和transient修饰的成员变量。
 *
 * 序列化机制：将内存中的Java对象转换成平台无关的二进制流，从而允许将二进制流持久地保存在磁盘上，或通过网络传输到另一个网络节
 *          点。当其他程序获得了这种二进制流，就可以恢复成原来的Java对象（反序列化）。
 *
 *          类实现Serializable或Externalizable接口，则其对象可进行序列化与反序列化。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 9:04
 * @Version: 1.0
 */
public class day24_09 {
    @Test
    public void test(){
        File srcFile = new File("a.jpeg");
        File destFile = new File("b.jpeg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(srcFile);
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(destFile);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        //数据输入输出流，将基本数据类型写入写出文件
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("张富财");
        dos.flush();
        dos.writeInt(32);
        dos.flush();
        dos.writeBoolean(true);

        dos.close();
    }

    @Test
    public void test3() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        String name = dis.readUTF();
        int num = dis.readInt();
        boolean is = dis.readBoolean();

        System.out.println("name: " + name);
        System.out.println("num: " + num);
        System.out.println("is: " + is);

        dis.close();
    }
}
