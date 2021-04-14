package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-02 16:02
 * @Modified By:
 */

import java.util.Scanner;

/**
 * @ClassName: day04
 * @Description
 * 1.switch后面使用的表达式可以是哪些数据类型？
 * byte,short,char,int,枚举类型变量,String类型。
 *
 * 2.使用switch语句改写下列if语句。
 *
 * 3.三元运算符、if-else、switch-case使用场景。
 * 三元运算符速度快，效率高；优先考虑使用
 * if-else：最后再用
 * switch-case：优先考虑使用
 *
 * 4.如何从控制台获取String和int变量并输出。
 * Scanner scanner = new Scanner(System.in);
 * while(scanner.hasNext()){
 *     String info = scanner.next();
 * }
 *
 * 5.使用for循环遍历100以内的奇数，并计算所有奇数的和。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/2 16:02
 * @Version: 1.0
 */
public class day04 {
//    public static final int dd = 0;
    public static void main(String[] args){

        System.out.println("args = " + args);

        sunJishu();

        scannerin();

        int a = 3;
        int x = 100;
//        if (a==1)
//            x+=5;
//        else if (a==2)
//            x+=10;
//        else if (a==3)
//            x+=16;
//        else
//            x+=34;

        //改为switch-case形式
        switch (a){
            case 1:
                x+=5;
                break;
            case 2:
                x+=10;
                break;
            case 3:
                x+=16;
                break;
            default:
                x+=34;
        }

    }

    public static void scannerin(){
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        System.out.println(a);
//        while (scanner.hasNext()){
//            Object str = scanner.next();
//            System.out.println(str.getClass());
//            if (str.getClass().equals("String")) {
//                System.out.println("String: " + str);
//            }
//            if (str.getClass().equals("Ingeter")){
//                System.out.println("Integer: " + str);
//            }
//        }
    }

    public static void sunJishu(){
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("sum: " + sum);
    }
}
