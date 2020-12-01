package mybatis.dao;

import mybatis.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-28
 * Time: 21:50
 */
public interface TeacherDao {

    @Select("select * from teacher")
    List<Teacher> selectTeacher();


    @Insert("insert into teacher(name) values(#{name})")
    int insertTeacher(Teacher teacher);
}
