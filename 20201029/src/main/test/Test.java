import mybatis.dao.ClassRoomDao;
import mybatis.dao.StudentDao;
import mybatis.dao.TeacherDao;
import mybatis.model.Student;
import mybatis.model.Teacher;
import org.apache.ibatis.session.SqlSession;
import util.DBUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-28
 * Time: 21:59
 */
public class Test {

    private SqlSession sqlSession;

    @org.junit.Test
    public void selectTeacher() {
        for (Teacher teacher : getTeacherDao().selectTeacher()) {
            System.out.println(teacher);
        }
        close();
    }

    @org.junit.Test
    public void insertTeacher() {
        System.out.println(getTeacherDao().insertTeacher(new Teacher(0, "Tom")));
        close();
    }

    @org.junit.Test
    public void selectStudent() {
        for (Student student : getStudentDao().selectStudent()) {
            System.out.println(student);
        }
        close();
    }

    @org.junit.Test
    public void selectStudent2() {
        for (Student student : getStudentDao().selectStudent2()) {
            System.out.println(student);
        }
        close();
    }


    @org.junit.Test
    public void insertStudent() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "booset");
        map.put("tid", 1);
        getStudentDao().insert(map);
        close();
    }

    @org.junit.Test
    public void updateStudent() {
        System.out.println(getStudentDao().update(2, "rose"));
        close();
    }

    @org.junit.Test
    public void ClassRoom() {
        System.out.println(getClassRoomDao().getClassRoom(1));
        close();
    }

    @org.junit.Test
    public void ClassRoom2() {
        System.out.println(getClassRoomDao().getClassRoom2(1));
        close();
    }



    private TeacherDao getTeacherDao() {
        sqlSession = DBUtil.getSqlSession();
        return sqlSession.getMapper(TeacherDao.class);
    }

    private StudentDao getStudentDao() {
        sqlSession = DBUtil.getSqlSession();
        return sqlSession.getMapper(StudentDao.class);
    }

    private ClassRoomDao getClassRoomDao() {
        sqlSession = DBUtil.getSqlSession();
        return sqlSession.getMapper(ClassRoomDao.class);
    }

    private void close() {
        sqlSession.close();
    }
}
