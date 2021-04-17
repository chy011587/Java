package com.lib.thread;

//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程

//总结；注意，线程开启不一定立即执行，由cpu调度执行
public class TestThread01 extends Thread {
    @Override
    public void run(){
        //run方法线程体
        for (int i = 0; i < 5; i++) {
            System.out.println("我在看代码---"+i);
        }
    }

    public static void main(String[] args) {
        //主方法main线程，主线程

        //创建一个线程对象，调用start方法开启线程；
        TestThread01 testThread01 = new TestThread01();
        testThread01.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("我在学习多线程---"+i);
        }
    }
}
