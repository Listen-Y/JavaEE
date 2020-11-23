package transaction.mapper;

import transaction.model.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 13:04
 */
public interface StudentMapper {

    List<Student> selectStudent();

    int insert(Student student);

    int delete(int id);



}
