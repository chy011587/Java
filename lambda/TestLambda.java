package com.lambda;

public class TestLambda {

    //3.静态内部类
    static class Like2 implements Ilike{
        @Override
        public void Lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {

        //4.局部内部类
        class Like3 implements Ilike{
            @Override
            public void Lambda() {
                System.out.println("i like lambda3");
            }
        }

        new Like().Lambda();
        new Like2().Lambda();
        new Like3().Lambda();
        Ilike like = new Like();

        //5.匿名内部类
        like = new Ilike() {
            @Override
            public void Lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.Lambda();

        //6.用lambda简化
        like = ()-> {
            System.out.println("i like lambda5");
        };
        like.Lambda();

    }
}

//1.定义一个函数式接口
interface Ilike{
    void Lambda();
}

//2.实现类
class Like implements Ilike{
    @Override
    public void Lambda() {
        System.out.println("i like lambda");
    }
}

