package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-02 21:46
 * @Modified By:
 */

/**
 * @ClassName: day07
 * @Description
 * 1.使用冒泡排序，实现数组排序(冒泡排序比较相邻元素之间的值)
 * int[] arr = new int[]{34,5,22,-98,6,-76,0,-3}
 *
 * 2.反转数组
 *
 *
 * 3.复制数组，得到一个新的数组
 *
 * 4.线性查找22，返回索引；不存在则输出提示信息。
 *
 * 4.数组中的常见异常。
 *   ArrayIndexOutOfBoundsException: 数组角标越界；
 *   NullPointerException: 空指针异常；
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/2 21:46
 * @Version: 1.0
 */
public class day07 {
    public static void main(String[] args){
//        Maopao();
//        CopyArr();
//        searchArr();
        reverseArr();
    }
    public static void Maopao(){
        //1.冒泡排序：相邻元素依次进行比较，若值大，则向后交换，直到比较末尾；再从头进行。
        int[] arr = {34,5,22,-98,6,-76,0,-3};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {  //减去i表示将已经排号的数减去
                //与相邻的数进行比较
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for (int x: arr){
            System.out.print(x + " ");
        }
    }

    public static void reverseArr(){
        //2.反转数组，依次交换首位元素
        int[] arr = {34,5,22,-98,6,-76,0,-3};

        System.out.print("arr: ");
        for (int a: arr){
            System.out.print(a + " ");
        }
        for (int i=0;i<arr.length / 2;i++){
            int tmp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }
        System.out.println();
        System.out.print("reverseArr: ");
        for (int b: arr){
            System.out.print(b + " ");
        }
    }

    public static void CopyArr(){
        //3.复制数组，开辟一个新数组，将元素赋值进去
        int[] arr = {34,5,22,-98,6,-76,0,-3};
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        System.out.print("arr: ");
        for (int a: arr){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.print("newArr: ");
        for (int b: newArr){
            System.out.print(b + " ");
        }
    }

    public static void searchArr(){
        //4.线性查找：遍历数组，依次查找
        int[] arr = {34,5,22,-98,6,-76,0,-3};
        int dest = 100;
        for (int i=0;i<arr.length;i++){
            if (dest == arr[i]){
                System.out.println("索引为： " + i);
                break;
            }
            if (i == arr.length-1){
                System.out.println("没有找到" + dest);
            }
        }
    }
}
