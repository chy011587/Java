package com.cheng.method;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("欢迎使用简单计算器");

        System.out.print("请输入第一个数字：");
        int num1 = s.nextInt();

        System.out.print("请输入运算符：");
        String operator = s.next();

        System.out.print("请输入第二个数字：");
        int num2 = s.nextInt();

        int result = 0;

        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 * num2;
                break;
            case "%":
                result = num1 % num2;
        }

        System.out.println(num1+operator+num2+"="+result);
    }
}
