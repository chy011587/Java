package com.syn;

//信号灯法测试生产消费者问题，标识位
public class TestPC2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread p = new Thread(new Product(shop),"生产者");
        Thread c = new Thread(new Customer(shop),"消费者");
        p.start();
        c.start();
    }
}

//商品
class Goods{
    private int id;
    public Goods(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

}

//超市
class Shop{
    Goods goods;
    boolean flag;// 标识商品是否充足
    // 生产者调用的 存的方法
    public synchronized void saveGoods(Goods goods) throws InterruptedException {
        if (flag==true){
            System.out.println("生产者：库存充足，等待库存卖完...");
            this.wait();// 商品充足，生产者不用生产，而等待消费者买完！进入等待状态
        }
        // 商品不充足！生产者生产商品，存到商场里
        System.out.println(Thread.currentThread().getName()+"生产并在商场里存放了" + goods.getId() + "件商品");
        this.goods = goods;
        flag = true;// 已经有商品了！可以让消费者购买了！
        // 消费者等待...
        this.notifyAll();// 将等待队列的消费者唤醒！前来购买商品
    }

    // 消费者调用的 取的方法
    public synchronized void buyGoods() throws InterruptedException {
        if (flag==false){// 没有商品了！消费者就要等待！
            System.out.println("消费者：商品不充足了，等待商品上架...");
            this.wait();
        }
        // 正常购买商品
        System.out.println(Thread.currentThread().getName() + "购买了" + goods.getId() + "件商品");
        // 商品买完了！标识没货了！
        this.goods = null;
        flag = false;
        // 唤醒生产者去生产商品
        this.notifyAll();

    }


}

//生产者
class Product implements Runnable{
    Shop shop;
    public Product(Shop shop){
        this.shop = shop;
    }
    @Override
    public void run() {
        // 通过循环，生产商品存放到Shop里
        for (int i = 1; i <= 10; i++) {
            try {
                this.shop.saveGoods(new Goods(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Customer implements Runnable{
    Shop shop;//商城
    public Customer(Shop shop){
        this.shop = shop;
    }
    @Override
    public void run() {// for循环模拟买商品
        for (int i = 1; i <= 10; i++) {
            try {
                this.shop.buyGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}