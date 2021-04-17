package round2.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test08 {
    //普通方式调用
    public static void test01(){
        User user = new User();
        long starTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("普通方法执行10亿次的时间"+(endTime-starTime)+"ms");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
       Method getName =  c1.getDeclaredMethod("getName",null);
        long starTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方法执行10亿次的时间"+(endTime-starTime)+"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName =  c1.getDeclaredMethod("getName",null);
        getName.setAccessible(true);
        long starTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("关闭检测后执行10亿次的时间"+(endTime-starTime)+"ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();

    }

}
