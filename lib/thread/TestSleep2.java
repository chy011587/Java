package com.lib.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

//倒计时
public  class TestSleep2 {
    public static void main(String[] args) {
        //打印当前系统时间
        Date starTime = new Date(System.currentTimeMillis());//获取系统当前的时间
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(starTime));
                starTime = new Date(System.currentTimeMillis());//更新系统当前的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }
}
