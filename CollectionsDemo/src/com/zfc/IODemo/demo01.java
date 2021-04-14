package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 22:11
 * @Modified By:
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName: demo01
 * @Description
 * 1.File类的一个对象，代表一个文件或一个文件目录
 *      File(String filePath):仅仅创建了一个内存的对象，没有真正的硬盘文件.
 *
 * 2.适用于文件目录：
 *      String[] file.list():获取下一级文件目录或文件的名称数组
 *      File[] file.listFiles():获取下一级文件或文件目录的File数组
 *
 * 3.file1.renameTo(file2):把文件重命名为指定的文件路径
 *      要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
 *
 * 4.创建真实的硬盘文件或文件目录，根据File对象创建。
 *      public boolean createNewFile():创建文件。若文件存在，则不创建，返回false。
 *      public boolean mkdir():创建文件目录。如果目录存在，就不创建。如果上层目录不存在，也不创建。
 *      public boolean mkdirs():创建文件目录，若上层文件目录不存在，一并创建。
 *
 *      若要操作文件中的内容，需要使用IO流。IOStream。
 *      File对象通常作为参数传递到流的构造器中，指明IO的终点。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 22:11
 * @Version: 1.0
 */
public class demo01 {
    @Test
    public void test(){
        File file1 = new File("hello.txt");  //相对于Module下面的路径
        File file2 = new File("D:\\IDEA\\workplace1\\CollectionsDemo\\hi.txt");

        File file3 = new File("D:\\IDEA\\workplace1","CollectionsDemo");

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);

        File file4 = new File(file3,"hi1.txt");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file = new File("hello.txt");

        System.out.println(file.getAbsoluteFile());  //获取绝对路径
        System.out.println(file.getPath());  //获取路径
        System.out.println(file.getName());  //获取名称
        System.out.println(file.getParent());  //获取上层文件目录。若无则返回null
        System.out.println(file.length());  //获取文件长度。不能获取目录的长度
        System.out.println(new Date(file.lastModified()));  //获取最后一次修改时间
    }

    @Test
    public void test3(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\IDEA\\workplace1\\demo.txt");  //会删除file1，在指定路径下创建file2

        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    @Test
    public void test4() throws IOException {
        File file = new File("test.txt");  //仅仅是一个对象
        //创建之前先判断是否存在
        if (!file.exists()) {
            file.createNewFile();  //创建真实的文件
            System.out.println("创建成功");
        }else {
            file.delete();
            System.out.println("删除成功");
        }

        //public boolean delete():删除硬盘中的文件或文件夹（不走回收站）
    }
}
