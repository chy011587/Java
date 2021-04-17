package round2.reflection;

//测试类什么时候被测试化
public class Test05 {
static {
    System.out.println("Main类被加载");
}

    public static void main(String[] args) throws ClassNotFoundException {
//        // 1.主动引用
//        Son son = new Son();

//        // 2.反射也会产生主动引用
//        Class.forName("round2.reflection.Son");

         // 3.不会产生类的引用的方法
//       3.1 System.out.println(Son.b);

//       3.2 Son[] arry = new Son[5];

System.out.println(Son.M);
    }
}

class Father{

    static int b = 2 ;
    static {
        System.out.println("父类静态代码块被初始化");
    }
}

class Son extends Father{
    static {
        System.out.println("子类静态代码块被初始化");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;//常量池
}