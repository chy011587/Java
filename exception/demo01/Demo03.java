package com.exception.demo01;

public class Demo03 {
    public static void main(String[] args) {
        try {
            new Demo03().test(1,0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void test(int a,int b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException(); //主动抛出异常 throw，一般用在方法中
        }
        System.out.println(a/b);
    }
}
