package com.lib.thread;

//观测线程状态
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("-----------");
        });

        //观察启动前
        Thread.State state = thread.getState();
        System.out.println(state);  //new

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);  //run

        while (state != Thread.State.TERMINATED){   //只要线程不中止，就一直输出状态
            Thread.sleep(500);
            state = thread.getState();//更新线程状态
            System.out.println(state);
        }

    }

}
