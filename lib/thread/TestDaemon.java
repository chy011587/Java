package com.lib.thread;

//测试守护线程
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Person person = new Person();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认false是用户线程，正常的线程都是用户线程

        thread.start();//上帝守护线程启动
        new Thread(person).start();//Person 用户线程启动
    }
}

//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("god bless you!");
        }
    }
}

//人
class Person implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("开心的活着！");
        }
        System.out.println("goodbye to world！");
    }
}
