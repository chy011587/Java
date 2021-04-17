package com.syn;
/*
 * 问题：两个线程同时访问临界资源时，出现的问题
 * 实例问题：妻子、丈夫携主、副卡在同一个银行账户中取钱（两个线程访问临界资源对象）
 *
 * 妻子正在读卡...
 * 验证成功！
 * 丈夫正在读卡...
 * 验证成功！
 * 妻子取款成功！卡内余额为：0.0元
 * 丈夫取款成功！卡内余额为：-200.0元
 *
 * 解决：为临界资源的原子操作加同步代码块（锁）synchronized
 * 1.为取款方法加锁，因为取款就是原子操作，从插卡验证，到取款成功的一系列步骤，不可缺少或打乱
 * 2.在取款方法内部加同步代码块，锁住的this即是当前账户的实例对象
 * 3.为所有取出钞票的那一步原子操作加锁，包括妻子和丈夫
 *
 * 思路：如果丈夫先拿到锁，他就会先取钱，后台将取出钱后的余额修改数据，而妻子再取钱的时候，余额不足
 *      抢到锁之后妻子在等锁，即是阻塞状态
 *
 * 注意：锁是随机的被线程抢到的！
 *
 * //什么场景下加锁？什么场景下不加锁？
 * //写（增、删、改） 操作---> 加锁！
 * //读操作 不加锁
 */
public class TestSynchronized {
    public static void main(String[] args) {
        //临界资源，只有一张银行卡
        //临界资源对象只有一把锁
        Account account = new Account("0001","123456",2000);
        Thread husband = new Thread(new Husband(account),"丈夫");
        Thread wife = new Thread(new Wife(account),"妻子");
        wife.start();
        husband.start();
    }
}

class Account {   //银行账户
    String cardNo;
    String passWord;
    double balance;

    public Account(String cardNo,String passWord,double balance){
        this.cardNo = cardNo;
        this.passWord = passWord;
        this.balance = balance;
    }

    //取款(原子操作，从插卡验证，到取款成功的一系列步骤，不可缺少或打乱)
    public synchronized void withdrawal(String cardNo,String passWord,double money){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"正在读卡...");
            //(原子操作，从插卡验证，到取款成功的一系列步骤，不可缺少或打乱)
            if (this.cardNo.equals(cardNo)&&this.passWord.equals(passWord)){
                System.out.println("验证成功！");
                if (money<=this.balance){
                    //模拟现实世界，正在数钞
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.balance -= money;//取出
                    System.out.println(Thread.currentThread().getName()+"取款成功，卡内余额："+this.balance+"元");
                }else {
                    System.out.println(Thread.currentThread().getName()+"卡内余额不足！余额："+balance+"元");
                }
            }else {
                System.out.println("卡号或密码不正确！");
            }
        }
    }
}
class Husband implements Runnable{
    Account account;
    public Husband(Account account){
        this.account = account;
    }
    //线程任务
    @Override
    public void run() {
        synchronized (account){
            this.account.withdrawal("0001","123456",500);//原子操作
        }
    }
}

class Wife implements Runnable{
    Account account;
    public Wife(Account account){
        this.account = account;
    }
    //线程任务
    @Override
    public void run() {
        synchronized (account){
            this.account.withdrawal("0001","123456",2000);//原子操作
        }
    }
}