package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-02 16:37
 * @Modified By:
 */

/**
 * @ClassName: day05
 * @Description:
 * 1.写出一维数组初始化的两种方式：（需要初始化数组的长度，且不可改变）
 * int[] arr = new int[3];  指定长度，动态初始化
 * int[] arr1 = new int[]{1,2,3}   指定元素，静态初始化
 *
 * 2.写出二维数组初始化的两种方式：
 * int[][] arr3 = new int[][]{{1},{1,2,3},{4,5}}
 * int[][] arr4 = new int[2][3];
 *
 * 3.如何遍历如下的二维数组：int[] arr = new int[][]{{1,2,3},{4,5},{6,7,8}};
 *
 * 4.不同类型的一维数组元素的默认初始化值各是多少？
 * 引用类型 arr: null;
 * 整型 arr1: 0;
 * boolean: false;
 * 浮点型：0.0
 * char：0
 *
 * 5.一维数组的内存解析：
 *      String[] strs = new String[5];
 *      strs[2] = "Tom";
 *      strs = new String[3];
 *
 *  局部变量在栈中，对象在堆中。
 *  栈：                            堆：
 *                                      0x89ac [null] （String[5]）   0x78aa [null] (String[3])
 *                                             [null]                        [null]
 *                                             [null]->"Tom"的地址            [null]
 *                                             [null]
 *                                             [null]
 *  strs = 0x77aa.(指向String[3]堆中对象的首地址)    常量池： "Tom"存在常量池中
 *  strs = 0x89ac.(指向String[5]堆中对象的首地址)
 *
 *  引用类型变量的值（地址或null）
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/2 16:37
 * @Version: 1.0
 */
public class day05 {
    public static void main(String[] args){
        //数组初始化
        int[] arr1 = new int[3]; //动态初始化
        int[] arr2 = {1,2,3};  //静态初始化

        int[][] arr = new int[][]{{1,2,3},{4,5},{6,7,8}};
//        for (int i=0;i<arr.length;i++){
        for (int[] b: arr){
            for (int a:b){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
