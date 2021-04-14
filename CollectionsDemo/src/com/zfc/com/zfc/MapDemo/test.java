package com.zfc.com.zfc.MapDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 09:03
 * @Modified By:
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName: test
 * @Description
 * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来。
 *
 * 2.请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 9:03
 * @Version: 1.0
 */
public class test {
    //输入10个整数保存到List中
    public static void main(String[] args) throws IOException {

        ArrayList list = new ArrayList();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int tmp = scanner.nextInt();
            list.add(tmp);
        }
        System.out.println(list.size());
        System.out.println(list);

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer){
                    return -Integer.compare((Integer) o1,(Integer) o2);
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        System.out.println(list);

//        Collections.reverse(list);
//        System.out.println(list);
    }
}
