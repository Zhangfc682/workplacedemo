package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 09:43
 * @Modified By:
 */

/**
 * @ClassName: WindowTest
 * @Description 创建三个窗口卖票，总票数为 100 张
 * @Author: Zhangfucai
 * @Date: 2021/4/1 9:43
 * @Version: 1.0
 */
public class WindowTest {
    public static void main(String[] args){
        window t1 = new window();
        window t2 = new window();
        window t3 = new window();

        t1.setName("窗口1：");
        t2.setName("窗口2：");
        t3.setName("窗口3：");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window extends Thread{
    //卖票窗口
    private static int ticket = 100;  //静态变量，依赖于类存在，三个对象共享一个类变量

    @Override
    public void run() {
        while (true){
            //线程具体的任务
            if (ticket > 0){
                System.out.println(getName() + "卖票，票号： " + ticket);
                ticket--;
            }else
                break;
        }
    }
}