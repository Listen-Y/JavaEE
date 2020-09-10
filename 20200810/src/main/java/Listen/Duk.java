package Listen;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-12
 * Time: 18:55
 */
public class Duk {
    private String name;
    private int age;
    private Duk next;

    public Duk(String name, int age, Duk next) {
        this.name = name;
        this.age = age;
        this.next = next;
    }

    public Duk() {

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

    public Duk getNext() {
        return next;
    }

    public void setNext(Duk next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Duk{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
