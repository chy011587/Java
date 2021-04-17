package round2.reflection;

//测试什么叫反射
public class Test01 {
    public static void main(String[] args) throws Exception {
        Class c1 = Class.forName("round2.reflection.User");
        System.out.println(c1);

        //hashCode相等，说明属于同一个类
        //一个类在内存中只会有一个class对象
        //一个类被加载后，类的整个结构都会被封装在class对象中
        Class c2 = Class.forName("round2.reflection.User");
        Class c3 = Class.forName("round2.reflection.User");
        Class c4 = Class.forName("round2.reflection.User");
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());

    }
}

//实体类：pojo /entity
class User{
    private String name;
    private int id;
    private int age;

    public User(){

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
