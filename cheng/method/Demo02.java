package com.cheng.method;

public class Demo02 {
    public static void main(String[] args) {
        int max=max(10,20);
        System.out.println(max);
    }
    //比大小
    public static int max(int num1,int num2){
        int result;
        if (num1==num2){
            System.out.println("num1等于num2");
            return 0;//return除了返回值，也可以终止方法
        }
        if (num1>num2){
            result=num1;
        }else {
            result=num2;
        }
        return result;
    }
}
