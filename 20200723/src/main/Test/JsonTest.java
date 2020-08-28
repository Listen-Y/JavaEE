import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * json study
 * User: Listen-Y.
 * Date: 2020-07-24
 * Time: 15:41
 */

class Person {

    private String name;
    private int age;
    private String sex;
    private int grade;

    public Person(String name, int age, String sex, int grade) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person("listen", 20, "man", 100);
        String jsonString = mapper.writeValueAsString(person);
        System.out.println(jsonString);
    }
}
