package com.exception.demo01;

public class Demo02 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        //选中执行的步骤，快捷键：Ctrl + Alt + T
        try {
            System.out.println(a/b);
        } catch (Exception e) {
            e.printStackTrace(); //打印错误的栈信息
        } finally {
        }
    }
}
