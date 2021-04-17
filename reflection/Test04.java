package round2.reflection;

public class Test04 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

    }
}
class A{
    static {
        System.out.println("A类静态代码块初始化");
        int m = 300;
    }

    static int m =100;

    public A() {
        System.out.println("A类构造器初始化");
    }
}
