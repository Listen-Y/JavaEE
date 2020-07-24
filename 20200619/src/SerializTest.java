import java.io.*;

//实现serializable接口才可以实现对象的序列化
class Person implements Serializable {
    public String name;
    public int age;
    public String sex;
    //transient修饰的变量不可以序列化
    transient public String cardId;
    //static 修饰的变量不能被序列化
    public static String phoneNum;

    public Person(String name, int age, String sex, String cardId) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.cardId = cardId;
    }

    public static void setPhoneNum(String phoneNum) {
        Person.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", cardId='" + cardId + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
public class SerializTest {

    public static void main(String[] args) {

        Person person = new Person("Listen", 21, "MAN", "100100100111");
        Person.setPhoneNum("120");

        //序列化一个对象
        serializPreson(person);

        //反序列化一个对象
        Person personRet = desSerializable();
        System.out.println(personRet);


    }

    private static Person desSerializable() {

        Person person = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\java\\java.txt"))){

            person = (Person) objectInputStream.readObject();
            System.out.println("反序列化成功");

        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }

        return person;
    }

    private static void serializPreson(Person person) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\java\\java.txt"))){

            //将person对象序列化输入文件
            // 这个 writeObject 集序列化+写文件 两者同时搞定
            objectOutputStream.writeObject(person);
            System.out.println("序列化成功");

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
