package com.syn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池
        //newFixedThreadPool() 参数为线程池大小

        //2.执行
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new TestPool1());
        service.execute(new TestPool1());
        service.execute(new TestPool1());
        service.execute(new TestPool1());

        //3.结束链接
        service.shutdown();
    }
}

class TestPool1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
