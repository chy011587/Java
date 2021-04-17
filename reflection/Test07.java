package round2.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象执行方法
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("round2.reflection.User");

        //构造一个对象
        User user =(User) c1.newInstance();     //本质是调用了类的无参构造器，这要求类中必须定义了无参构造器
        System.out.println(user);

        //通过构造器创造对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);//对类中是否有无参构造器无具体要求
        User user2 =(User) constructor.newInstance("ch1", 001, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获得方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"ch1");    //invoke ： 激活
                                                //invoke(对象，"方法的值")
        System.out.println(user3.getName());

        // 通过反射创造属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作private，需要关闭它的安全检测
        name.setAccessible(true);               //取消安全检测
        name.set(user4,"ch2");
        System.out.println(user4.getName());
    }
}
