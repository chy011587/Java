package com.oop.demo02;

//学生类
public class Student {

    //属性
    String name;
    int age;

    //方法
    public void study(){
        System.out.println(this.name+"在学习");
    }

}
/*

        //类：抽象的，需要实例化
        //类实例化后会返回一个自己的对象：
        //student对象就是一个Student类的具体实例！
        Student ch1 = new Student();
        Student ch2 = new Student();

        ch1.name = "chy01";
        ch2.name = "chy02";
        ch1.age = 21;
        ch2.age = 22;

        System.out.println(ch1.name);
        System.out.println(ch1.age);
        System.out.println(ch2.name);
        System.out.println(ch2.age);
 */