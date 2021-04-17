package com.cheng.array;

import java.util.Arrays;

public class Demo06 {
    public static void main(String[] args) {
        int[] a = {1,5,4,6,3,2};
        int[] a2 = {1,5,4,6,3,2};
        System.out.println(Arrays.toString(a));//打印数组元素
        System.out.println("=================");
        Arrays.equals(a,a2);                  //数组比较
        System.out.println("a与a2比较结果为："+Arrays.equals(a,a2));
        System.out.println("=================");
        Arrays.sort(a);                       //数组排序：升序
        System.out.println(Arrays.toString(a));
        System.out.println("=================");
        Arrays.binarySearch(a,3);
        System.out.println(Arrays.binarySearch(a,3));
        //有数组元素3，从下标0开始计数
        System.out.println(Arrays.binarySearch(a,7));
        //无数组元素7，从1开始计数，且无数组元素要加"-"
        System.out.println("=================");
        Arrays.fill(a,2,4,0);
                                             //数组下标从2到4的元素赋值为0
        System.out.println(Arrays.toString(a));
        System.out.println("=================");
        Arrays.fill(a,0);                //数组元素赋值为0
        System.out.println(Arrays.toString(a));

    }
}
