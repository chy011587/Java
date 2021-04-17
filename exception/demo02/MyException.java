package com.exception.demo02;

//自定义的异常类
public class MyException extends Exception{

    //传递数字 >10 抛出异常；
    private int detail;
    public MyException(int a){
        detail = a;
    }
    //toString：异常的打印信息
    public String  toString(){
        return "MyException{" +
                "detail=" + detail + '}';
    }
}
