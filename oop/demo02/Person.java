package com.oop.demo02;

public class Person {
    //一个类即使什么也不写，它也会存在一个方法
    //显示得去定义构造器
    String name;

    //1.使用new关键字，本质是在调用构造器
    //2.用来初始化值

    //有参构造：一旦定义了有参构造，无参就必须显示定义

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    //alt + insert
}

/*
   public static void main(String[] args) {
    Person person = new Person("ch1");
        System.out.println(person.name);
    }

    构造器：
        1.和类名相同
        2.没有返回值
    作用：
        1.new本质在构造方法
        2.初始化对象的值
    注意点：
        1.定义了有参构造，如果想使用无参构造，必须要显示得去定义一个无参构造

        alt + insert
 */
