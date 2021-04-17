package com.oop.Demo04;

/*
  封装的好处：
    1. 提高程序的安全性，保护数据
    2. 隐藏代码的实现细节
    3. 统一接口
    4. 提高系统的可维护性
 */
//类     private:私有
public class Student {

    //属性私有
    private String name;//名字
    private int id;//学号
    private char sex;//性别
    private int grade;//年级

    //提供一些可以操作这个属性的方法！
    //提供一些public 的 get、set方法

    //get 获得这个数据
    public String getName(){
        return this.name;
    }

    //set 给这个数据设置值
    public void setName(String name){
    this.name = name;
    }

    //alt + insert快捷键获得get/set方法

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public char getSex(){
        return sex;
    }
    public void setSex(char sex){
        this.sex = sex;
    }

    public int getGrade(){
        return grade;
    }

    public void setGrade(int grade){
        //属性私有并封装可以进行 '安全性检查'
        if (grade<0 || grade>=9){
            System.out.println("请输入您所在年级");
        }else{
            this.grade = grade;
        }
    }
}

/*
package com.oop.Demo04;
public class Application {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.setName("ch1");
        System.out.println("姓名："+s1.getName());

        s1.setGrade(4);
        System.out.println("年纪："+s1.getGrade());

        s1.setId(2018011587);
        System.out.println("学号："+s1.getId());

        s1.setSex('m');
        System.out.println("性别："+s1.getSex());


    }
}
 */