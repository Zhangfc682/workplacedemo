package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-07 22:36
 * @Modified By:
 */

/**
 * @ClassName: Car
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/7 22:36
 * @Version: 1.0
 */
public class Car implements Comparable{
    private String name;
    private int num;

    public Car() {
    }

    public Car(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (num != car.num) return false;
        return name != null ? name.equals(car.name) : car.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + num;
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Object o) {
        //name从小到大，num从大到小
        if (o instanceof Car){
            Car c = (Car)o;
            if (this.name != c.name) {
                return this.name.compareTo(c.getName());
            }

            return -Integer.compare(this.num,c.getNum());
        }
        throw new RuntimeException("输入类型不匹配");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
