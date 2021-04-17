package com.cheng.method;

public class Demo03 {
    public static void main(String[] args) {
    Demo03  demo03 = new Demo03();
    demo03.test(11,12,13,14,15);

    }
    public void test(int...i){
        System.out.println(i[0]);
        System.out.println(i[1]);
        System.out.println(i[2]);
        System.out.println(i[3]);
        System.out.println(i[4]);

    }

}
