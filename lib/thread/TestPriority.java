package com.lib.thread;

public class TestPriority {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"的线程优先级为"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread thr1 = new Thread(myPriority);
        Thread thr2 = new Thread(myPriority);
        Thread thr3 = new Thread(myPriority);
        Thread thr4 = new Thread(myPriority);
        Thread thr5 = new Thread(myPriority);
        Thread thr6 = new Thread(myPriority);


        thr1.start();

        thr2.setPriority(3);
        thr2.start();

        thr3.setPriority(Thread.NORM_PRIORITY);
        thr3.start();

        thr4.setPriority(Thread.MAX_PRIORITY);
        thr4.start();

        thr5.setPriority(7);
        thr5.start();

        thr6.setPriority(9);
        thr6.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"的线程优先级为"+Thread.currentThread().getPriority());
    }
}
