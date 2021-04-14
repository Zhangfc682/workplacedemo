package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 15:16
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: demo03
 * @Description
 * 使用FileInputStream和FileOutputStream处理字节流
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/9 15:16
 * @Version: 1.0
 */
public class demo03 {
    @Test
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcImg = new File("001.jpeg");
            File destImg = new File("copy.jpeg");

            fis = new FileInputStream(srcImg);
            fos = new FileOutputStream(destImg);

            //设置字节装载器数组
            byte[] bBuf = new byte[16];
            int len;
            while ((len = fis.read(bBuf)) != -1){
                fos.write(bBuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //使用Buffered缓冲流包装节点流
            File srcFile = new File("001.jpeg");
            File destFile = new File("001_copy.jpeg");

            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

            byte[] buffer = new byte[8];
            int len;

            while ((len = bis.read(buffer))!=-1){
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

}
