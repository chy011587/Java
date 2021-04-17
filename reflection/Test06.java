package round2.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("round2.reflection.User");
//        User user = new User();                   通过对象获得包名加类名
//        c1 = user.getClass();

        //获得类的名称
        System.out.println(c1.getName());           //获得全部名字
        System.out.println(c1.getSimpleName());     //获得简单名字
        System.out.println("========================================");
        //获得类的属性
        //Field[] fields = c1.getFields();          //只能找到public属性

        Field[] fields = c1.getDeclaredFields();//可以找到所有属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("========================================");
        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        System.out.println("========================================");
        //获得类的方法
        Method[] methods = c1.getMethods();
        Method[] declaredMethods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("正常的："+ method);
        }
        for (Method declaredMethod : declaredMethods) {
            System.out.println("所有的："+declaredMethod);
        }
        System.out.println("========================================");
        //获得指定的方法
//        Method getName = c1.getMethod("getName", null);
//        Method setName = c1.getMethod("setName",String.class);
//        System.out.println(getName);
//        System.out.println(setName);
        System.out.println("========================================");
        //获得类的构造器
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("========================================");
        //获得指定的构造器
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(constructor);
    }
}
