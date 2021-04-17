package com.lambda;

public class TestLambda02 {
    public static void main(String[] args) {
        Ilove love = null;
//        Ilove love = (int a)->{
//            System.out.println("i love u"+a);
//        };
//        love = (a)->{
//            System.out.println("i love u"+a);
//        };
//
//        love = a -> {
//            System.out.println("i love u"+a);
//        };

        love = a -> System.out.println("i love u"+a);
        love.love(521);
    }
}

interface Ilove{
    void love(int a);
}

class Love implements Ilove{
    Love love = new Love();
    @Override
    public void love(int a) {
        System.out.println("I love u -->"+a);
    }
}
