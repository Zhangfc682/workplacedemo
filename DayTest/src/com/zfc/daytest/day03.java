package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-02 14:27
 * @Modified By:
 */

/**
 * @ClassName: day03
 * @Description
 * 1."&" 和 "&&" 的异同。
 * "&": 按位运算符 按位与
 * "&&": 逻辑运算符 与
 *
 * 2.程序输出：
 * boolean x = true;
 *         boolean y = false;
 *
 * //        System.out.println(y=true);
 * //        System.out.println(x=false);
 *
 *         short z = 40;
 *         if((z++ == 40) && (y = true)){  //后边为赋值运算符
 *             z++;
 *         }
 *         if ((x = false) || (++z == 43)){
 *             z++;
 *         }
 *         System.out.println("z = " + z);
 * 输出 z = 44
 *
 *
 * 3.定义三个int型变量并赋值，使用三元运算符或者if-else获取这三个数中的较大数的实现。
 *
 * 4.声明两个double型变量并赋值。判断第一个数大于10.0，且第二个数小于20.0，打印两个数之和。否则，打印两数之差。
 *
 * 5.交换两个变量值。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/2 14:27
 * @Version: 1.0
 */
public class day03 {
    public static void main(String[] args){

//        short z = 10;
//        z = (short) (z + 2);
//        z += 2;
        //3.
        int a = 1,b = 2,c = 3;
        int max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println(max);

        //2.
        boolean x = true;
        boolean y = false;

//        System.out.println(y=true);
//        System.out.println(x=false);

        short z = 40;
        if((z++ == 40) && (y = true)){  //后边为赋值运算符
            z++;
        }
        if ((x = false) || (++z == 43)){
            z++;
        }
        System.out.println("z = " + z);

        //4.
        double d = 15.0, e = 16.0;
        if (d > 10.0 && e <20.0){
            System.out.println(d + e);
        }else {
            System.out.println(d - e);
        }

        //5.
        Mine m1 = new Mine(3);
        Mine m2 = new Mine(4);
        swap(m1,m2);
        System.out.println("m1.num:" + m1.getNum() + " m2.num: " + m2.getNum());

        //移位运算
        System.out.println(e(2,3));
    }

    public static void swap(Mine a, Mine b){  //java基本数据类型是值传递的，不会改变原来的值
        //利用Java的调用方法来交换两个数字的值，没有那么直接，我们需要用到数组这个引用类型，才能在方法中实现两个数字的交换。
//        JAVA数据类型：
//
//        1、基本数据类型（byte,int,long,short,float,double,char,boolean)
//
//         在使用方法时，基本数据类型由于在内存中的一个地址存放的是这些变量的值，所以方法中的形参就是复制这些变量的值，所以不会影响
//          到原来变量的值。
//
//        2、对象引用数据类型(类，接口类型，数组类型，枚举类型，注解类型）

//          在使用方法时，引用类数据类型由于引用的是内存地址而不是具体的值，所以方法中的形参就是复制这些变量值的地址，在进行修改的时
//          候，会影响到原来的变量。
//
//          在Java中，对于基本数据类型，Java方法并不能修改变量内容，但是对于自定义类型是可以修改的，但参数传递使用的是值传递而非引
//          用传递。

        int tmp = a.getNum();
        a.setNum(b.getNum());
        b.setNum(tmp);
    }

    public static Integer e(Integer a,Integer b){
        //高效计算2 * 8，使用移位运算  2 << 3
        return a << b;
    }
}

class Mine{
    private int num;

    public Mine(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
