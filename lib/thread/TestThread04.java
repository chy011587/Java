package com.lib.thread;

//模拟抢火车票

//存在问题：多个线程操纵同一个资源的情况下，线程不安全，数据紊乱。
public class TestThread04 implements Runnable {

    private int ticketNums = 10;

    @Override
    public void run(){
        while (true){
                if (ticketNums<=0){
                    break;
                }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticketNums--+"张票");
        }
    }
    public static void main(String[] args) {
        TestThread04 ticket = new TestThread04();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"王五").start();
        new Thread(ticket,"刘六").start();
        new Thread(ticket,"黄牛党").start();
    }
}
