//package com.lib.thread;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//
////练习Thread，实现多线程同步下载图片
//public class TestThread02 extends Thread {
//
//    private String url;//网络图片地址
//    private String name;//保存的文件名
//
//    public TestThread02(String url, String name) {
//        this.url = url;
//        this.name = name;
//    }
//
//    //下载网络图片线程的执行体
//    @Override
//    public void run() {
//        WebDownloader01 webDownloader = new WebDownloader01();
//
//        webDownloader.downloader(url, name);
//        System.out.println("下载了文件名为" + name);
//    }
//
//    public static void main(String[] args) {
//        TestThread02 t1 = new TestThread02("https://img-home.csdnimg.cn/images/20210330052344.jpg", "1.jpg");
//        TestThread02 t2 = new TestThread02("https://img-home.csdnimg.cn/images/20210331091232.png", "2.png");
//        TestThread02 t3 = new TestThread02("https://img-home.csdnimg.cn/images/20210329115608.jpg", "3.jpg");
//        t1.start();
//        t2.start();
//        t3.start();
//    }
//}
//
////下载器
//class WebDownloader01{
//    //    //下载方法
//    public void downloader(String url,String name){
//        try {
//            FileUtils.copyURLToFile(new URL(url),new File(name));
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("IO异常，downloader方法出现问题");
//        }
//    }
//}
//
//
//
