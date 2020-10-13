import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-19
 * Time: 9:44
 */

class Person implements Comparable<Person> {
    private String name = "listen";
    private int age = 21;
    private int id = 20200909;

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

    public Person(){};

    @Override
    public boolean equals(Object o) {
        //第一步判断o是否为空
        if (o == null) {
            return false;
        }
        //第二步判断是不是同一个对象
        if (o == this) {
            return true;
        }
        //第三补判断是否可以强转为this这个类型
        if (! (o instanceof Person)) {
            return false;
        }
        //将o强转为this类型进行自定义判断
        Person person = (Person) o;
        if (person.getName().equals(this.name)) {
            return true;
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        return o.id - this.id;
    }

    private int prinfAll(int add) {
        return this.id + this.age + add;
    }
}
public class ReviewEquals {
}
