package Listen;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-11
 * Time: 15:26
 */
public class School {

    private List<Teacher> teachers;
    private String schoolName;

    public School() {

    }

    public School(List<Teacher> teachers, String schoolName) {
        this.teachers = teachers;
        this.schoolName = schoolName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "teachers=" + teachers +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
