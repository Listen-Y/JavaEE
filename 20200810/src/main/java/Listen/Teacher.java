package Listen;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-11
 * Time: 15:25
 */
public class Teacher {

    private Person person;
    private String teacherId;

    public Teacher() {

    }

    public Teacher(Person person, String teacherId) {
        this.person = person;
        this.teacherId = teacherId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "person=" + person +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
