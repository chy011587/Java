package round2.reflection;

import org.omg.SendingContext.RunTime;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//通过反射操作注解
public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("round2.reflection.Student2");
        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解value的值
        Tablech1 tablech1 = (Tablech1) c1.getAnnotation(Tablech1.class);
        String value = tablech1.value();
        System.out.println(value);

        //获得指定类注解
        Field f = c1.getDeclaredField("name");
        Fieldch1 annotation = f.getAnnotation(Fieldch1.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}
@Tablech1("db_student")
class Student2{

    @Fieldch1(columnName = "db_id",type = "int",length = 10)
    private int id;
    @Fieldch1(columnName = "db_age",type = "int",length = 10)
    private int age;
    @Fieldch1(columnName = "db_name",type = "varchar",length = 10)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablech1{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldch1{
    String columnName();
    String type();
    int length();
}