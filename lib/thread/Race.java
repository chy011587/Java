package com.lib.thread;
//模拟龟兔赛跑
public class Race implements Runnable {
    private static String winner;

    @Override
    public void run(){
        for (int i = 1; i <= 100; i++) {

            //模拟兔子跑到80米就睡觉休息
            if (Thread.currentThread().getName().equals("兔子") && i==80){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);
            //如果比赛结束了，就停止程序
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"米");
        }
    }

    //判断是否完成比赛
    public boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner!=null){
            return true;
        }else {
            if (steps>=100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is "+winner);
            return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}

