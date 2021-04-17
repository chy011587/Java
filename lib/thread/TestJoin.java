package com.lib.thread;

//测试join方法
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("vip来了"+i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //启动线程的方法
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程

        for (int i = 0; i < 10; i++) {
            if (i==8){
                thread.join();
            }
            System.out.println("main"+i);
        }

    }
}
