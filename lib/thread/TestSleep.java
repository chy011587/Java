package com.lib.thread;

import sun.security.krb5.internal.Ticket;

//模拟网络延时：放大问题的发生性，可以发现程序的问题所在
public class TestSleep implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run(){
        while (true){
            if (ticketNums<1){
                break;
            }

//模拟网络延迟
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticketNums--+"张票");
        }
    }
    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"王五").start();
    }
}
class Zhang implements Runnable{
    Ticket ticket;
    public Zhang(Ticket ticket){
        this.ticket = ticket;
    }
    @Override
    public void run() {
    synchronized (ticket){
        return;
    }
    }
}
class Li implements Runnable{
    Ticket ticket;
    public Li(Ticket ticket){
        this.ticket = ticket;
    }
    @Override
    public void run() {
        synchronized (ticket){
            return;
        }
    }
}
class Wang implements Runnable{
    Ticket ticket;
    public Wang(Ticket ticket){
        this.ticket = ticket;
    }
    @Override
    public void run() {
        synchronized (ticket){
            return;
        }
    }
}