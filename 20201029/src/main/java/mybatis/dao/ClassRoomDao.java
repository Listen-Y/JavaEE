package mybatis.dao;

import mybatis.model.ClassRoom;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-29
 * Time: 14:27
 */
public interface ClassRoomDao {

    ClassRoom getClassRoom(int tid);

    ClassRoom getClassRoom2(int tid);
}
