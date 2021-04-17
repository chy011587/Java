package com.syn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Test test = new Test();

        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
    }
}

class Test implements Runnable{

    int ticketNums = 10;
    //定义一个Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();    //加锁
                if (ticketNums<=0){
                    break;
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }

            }finally {
                lock.unlock();      //解锁

            }
        }
    }
}
