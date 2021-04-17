package com.syn;

//死锁：多个线程互相抱着对方需要的资源，然后形成僵持。
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"灰姑娘");
        Makeup g2 = new Makeup(1,"白雪公主");
        g1.start();
        g2.start();
    }
}

class Lipstick{
}

class Mirror{
}

class Makeup extends Thread{

    //需要的资源只有一份资源，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice ;
    String girlName;

    Makeup(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }
    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆，互相持有对方的锁
    private  void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipstick){
                System.out.println(this.girlName+"获得了口红的锁");
                Thread.sleep(1000);
                }synchronized (mirror){
                    System.out.println(this.girlName+"获得了镜子的锁");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获得了镜子的锁");
                Thread.sleep(2000);
                }synchronized (lipstick){
                System.out.println(this.girlName+"获得了口红的锁");
            }

        }
    }
}