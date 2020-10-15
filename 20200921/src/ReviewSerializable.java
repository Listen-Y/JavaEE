import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-21
 * Time: 10:21
 */

class Person implements Serializable {
    public String name;
    public int age;
    public transient int id;
    public static String sex;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

public class ReviewSerializable {

    public static void main(String[] args) {
        //构建一个对象
        Person person = new Person("Listen", 21, 20200909);
        Person.sex = "man";
        System.out.println("进行序列化");
        serializPerson(person);
        System.out.println("===================");
        System.out.println("进行反序列化");
        deSerializPerson();
    }

    private static void deSerializPerson() {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("D:/test/object.txt"))) {

            Person person = (Person) objectInputStream.readObject();

            System.out.println(person);
            System.out.println("=============");
            System.out.println(person.name);
            System.out.println(person.age);
            System.out.println(person.id);
            System.out.println(Person.sex);
            System.out.println("反序列化成功");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializPerson(Person person) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/test/object.txt"))) {

            //将person这个对象序列化写入到文件中
            //使用writeObject使其序列计划和写入文件一键操作
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            System.out.println("序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
