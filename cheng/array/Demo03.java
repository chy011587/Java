package com.cheng.array;

public class Demo03 {
    public static void main(String[] args) {
        int[]   array = {1,2,3,4,5};
        //打印全部数组元素
        for (int i = 0; i <array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("============");
        //计算全部元素的和
        int sum = 0;
        for (int i = 0; i <array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("sum="+sum);
        System.out.println("============");
        //判断出最大元素
        int max = array[0];
        for (int i = 1; i <array.length ; i++) {
            if (array[i]>max){
                max = array[i];
            }
        }
        System.out.println("max="+max);
    }
}
