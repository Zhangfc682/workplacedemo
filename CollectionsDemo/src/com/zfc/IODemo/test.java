package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 08:36
 * @Modified By:
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: test
 * @Description
 * File test
 * @Author: Zhangfucai
 * @Date: 2021/4/9 8:36
 * @Version: 1.0
 */
public class test {
    @Test
    public void test() throws IOException {
        //利用File构造器，new一个文件目录file。在其中创建多个文件和目录；编写方法，实现删除file中指定文件的操作
        File file = new File("D:\\IODemo");
        if (!file.exists()) {
            file.mkdirs();
            System.out.println("创建成功");
        }

//        System.out.println(file.list());

        File file1 = new File(file,"demo1.txt");
        File file2 = new File(file,"demo2.txt");
        File file3 = new File(file,"demo3");

        file1.createNewFile();
        file2.createNewFile();
        file3.mkdirs();
    }

    @Test
    public void test2() throws IOException {
        //判断指定目录下是否有后缀名为.jpg的文件，如果有就输出该文件名称
        File file = new File("D:\\IODemo"); // 指定目录
        if (!file.exists()){
            file.mkdirs();
            System.out.println("创建成功");
        }else {
            System.out.println("目录已经存在");
        }

        File file1 = new File(file,"dede.jpg");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("文件创建成功");
        }


        String[] list = file.list();  //返回当前目录下的File名称数组
        boolean found = false;

        for (String str : list){
            if (str.endsWith("jpg")){
                found = true;
                System.out.println(str);
            }
        }
        if (!found) {
            System.out.println("无");
        }
    }

    @Test
    public void test3(){
        //遍历指定目录所有文件名称，包括子文件目录中的文件
        //计算指定目录占用空间的大小
        //删除指定文件目录及其下的所有文件
        File file = new File("D:\\IODemo");

//        File[] files = file.listFiles();  //文件与文件夹都会返回
//        for (File f : files){
//            System.out.println(f.getName());
//        }
        printFile(file);
    }

    public static void printFile(File dir){ //函数功能：输出当前file的子目录
        //递归遍历文件目录
        File[] files = dir.listFiles();

        for (File f : files){
            if (f.isDirectory()){
                //若是目录，继续递归
                printFile(f);
            }else {
                //若是文件，进行输出
                System.out.println(f);
            }
        }
    }

    @Test
    public void test4(){
        File file = new File("D:\\IODemo");
//        File file = new File("D:\\IDEA\\workplace");
        printFile1(file);
    }

    public static void printFile1(File dir){  //函数功能：输出当前file的名称
        System.out.print("-");
        System.out.println(dir.getName());

        File[] files = dir.listFiles();
        for (File f : files){
            //终止条件，若是文件则输出
            if (f.isFile()){
                System.out.print("   -");
                System.out.println("-" + f.getName());
            }else {
                //等价条件，若依然是目录，继续遍历
                System.out.print("  -");
                printFile1(f);
            }
        }
    }

}
