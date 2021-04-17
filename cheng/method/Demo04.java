package com.cheng.method;

public class Demo04 {
    //5!  5*4*3*2*1
    //学习递归思想，大型运算不适用递归
    public static void main(String[] args) {
        System.out.println(f(5));
    }
    public static int  f(int n){
        if(n==1){
            return 1;
        }else {
            return n*f(n-1);
        }
    }
}
