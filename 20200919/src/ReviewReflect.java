import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-19
 * Time: 13:15
 */
public class ReviewReflect {

    public static void reflectNewInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> classPerson = Class.forName("Person");
        Person person = (Person) classPerson.newInstance();
        System.out.println(person);

        //通过类对象获得构造器, 构造器可以指定调用哪些个参数构造器来指定最后使用那些参数的newInstance创建对应的对象
        //但是注意使用getDeclaredConstructor创建private修饰的构造方法是要设置权限setAccessible(true)
        Person person1 = (Person) classPerson.getDeclaredConstructor(String.class, int.class, int.class).newInstance("aaa", 1,1);
        System.out.println(person1);
    }

    public static void reflectPrivateField() throws NoSuchFieldException, IllegalAccessException {
        Class<?> classPerson = Person.class;
        Field nameField = classPerson.getDeclaredField("name");
        //破坏私有权限
        nameField.setAccessible(true);
        Person person = new Person();
        nameField.set(person, "Franke");
        System.out.println(person);
    }

    public static void reflectPrivateMethond() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> personClass = Class.forName("Person");
        Method printAllMethod = personClass.getDeclaredMethod("prinfAll", int.class);
        //破坏私有权限
        printAllMethod.setAccessible(true);
        Person person = new Person();
        System.out.println(printAllMethod.invoke(person, 10000));
        //System.out.println(person);

    }



    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //reflectNewInstance();
        //reflectPrivateField();
        reflectPrivateMethond();
    }
}
