package com.syn;

//不安全购票
public class UnsafeBuyTickets {
    public static void main(String[] args) {
        BuyTickets station = new BuyTickets();
        new Thread(station,"小红").start();
        new Thread(station,"小明").start();
        new Thread(station,"小王").start();
        new Thread(station,"小李").start();
        new Thread(station,"小强").start();
    }
}

class BuyTickets implements Runnable{

    private int ticketNums = 10;
    boolean flag = true;//外部停止方式
    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized 同步方法
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums<=0){
            flag = false;
            return;
        }else {
            //买票
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");

        }
        //延时
        Thread.sleep(100);
    }
}
