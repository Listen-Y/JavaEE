package transaction.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import transaction.mapper.StudentMapper;
import transaction.model.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 13:11
 */
public class StudentMapperImpl extends SqlSessionDaoSupport implements StudentMapper {
    @Override
    public List<Student> selectStudent() {
        return super.getSqlSession().getMapper(StudentMapper.class).selectStudent();
    }

    @Override
    public int insert(Student student) {
        return super.getSqlSession().getMapper(StudentMapper.class).insert(student);
    }

    @Override
    public int delete(int id) {
        return super.getSqlSession().getMapper(StudentMapper.class).delete(id);
    }
}
