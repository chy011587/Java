package com.exception.demo01;

public class Demo01 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {       //try：监控区域
            System.out.println(a/b);
        }catch (Error e){     //catch(想要捕获的异常类型) 捕获异常
            System.out.println("Error");    //不属于Error类型
        }catch (Exception f){
            System.out.println("Exception");//属于Exception类型，执行
        }catch (Throwable g){
            System.out.println("Throwable");//捕获多个异常时，层层递进关系，上面执行后不再执行，由小到大不能颠倒
        } finally {
            System.out.println("finall");
        }
    }
}
