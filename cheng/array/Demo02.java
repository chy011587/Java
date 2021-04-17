package com.cheng.array;

public class Demo02 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};//数组的静态初始化
        System.out.println(a[0]);

        int[] b = new int[5];//数组的动态初始化
        b[0] = 1;
        b[1] = 2;
        System.out.println(b[0]);

        System.out.println(b[2]);//数组的默认初始化
    }
}
