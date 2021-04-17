package com.cheng.array;

public class Demo01 {
    //变量的类型     变量的名字   =   变量的值
    public static void main(String[] args) {
    int[]   nums;//声明一个数组
     nums = new int[10];//定义一个数组
    //int[]   nums  = new int[10];可以声明和定义一起进行
        //赋值
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        nums[6] = 7;
        nums[7] = 8;
        nums[8] = 9;
        nums[9] = 10;
        //计算总和
        //获取数组长度 nums.length
        int sum = 0;
        for (int i = 0; i <nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println(sum);
    }
}
