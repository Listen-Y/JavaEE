package annotationTx;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import tx.mapper.StudentMapper;
import tx.model.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 18:05
 */
public class StudentMapperImp implements StudentMapper {

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Student> selectStudent() {
        return sqlSession.getMapper(StudentMapper.class).selectStudent();
    }

    @Override
    public int insert(Student student) {
        return sqlSession.getMapper(StudentMapper.class).insert(student);
    }

    @Override
    public int delete(int id) {
        return sqlSession.getMapper(StudentMapper.class).delete(id);
    }
}
