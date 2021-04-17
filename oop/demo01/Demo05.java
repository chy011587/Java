package com.oop.demo01;
//引用传递:传递的是对象，本质还是值传递
public class Demo05 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);

        Demo05.change(person);
        System.out.println(person.name);
    }
    public static void change(Person person){
        person.name = "ch1";
    }
}
class  Person{
    String name;
}