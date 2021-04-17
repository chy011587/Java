package com.cheng.scanner;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        //从接受键盘数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用nextLine方式接受：");
        //判断用户有没有输入字符串
        if (scanner.hasNextLine()){
            String str = scanner.nextLine();//程序会等待用户输入完毕
            System.out.println("输入的内容为："+str);
        }
        scanner.close();
    }
}
