package com.oop;

import com.oop.demo10.Outer;

public class Application {
    public static void main(String[] args) {

        Outer outer = new Outer();
        //Inner通过外部类来实例化这个内部类
        Outer.Inner inner = outer.new Inner();
        inner.in();
        inner.getId();

    }
}