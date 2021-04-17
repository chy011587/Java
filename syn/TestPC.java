package com.syn;

//管程法解决消费者生产者模型
public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }

    //生产

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    //消费

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+container.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;


    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //容器满了，需要等待消费者消费
        if (count==chickens.length){
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //容器没有满，就需要丢入产品
        chickens[count] = chicken;
        count++;

            //通知消费者消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断是否消费
        if (count==0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //存在数据，进行消费
        count--;
        Chicken chicken = chickens[count];
        //吃完后通知生产者生产
        this.notifyAll();
        return chicken;
    }

}
