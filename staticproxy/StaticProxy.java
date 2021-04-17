package com.staticproxy;

public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).HappyMerry();
        new Thread(()-> System.out.println("i love u")).start();
    }
}

interface Merry{
    void HappyMerry();
}

//真实角色
class You implements Merry{

    @Override
    public void HappyMerry() {
        System.out.println("ch1要结婚了");
    }
}

//代理角色
class WeddingCompany implements Merry{

    private Merry target;

    WeddingCompany(Merry target) {
        this.target = target;
    }


    @Override
    public void HappyMerry() {
        before();
        this.target.HappyMerry();
        after();
    }

    private void after() {
        System.out.println("收尾款");
    }

    private void before() {
        System.out.println("布置现场");
    }
}

