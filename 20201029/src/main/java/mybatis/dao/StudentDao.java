package mybatis.dao;

import mybatis.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.INTERNAL;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-29
 * Time: 13:13
 */
public interface StudentDao {

    //查询所有学生
    List<Student> selectStudent();

    //查询所有学生
    List<Student> selectStudent2();

    void insert(Map<String, Object> map);

    @Update("update student set name=#{newName} where id=#{id}")
    int update(@Param("id") int id, @Param("newName") String newName);

}
