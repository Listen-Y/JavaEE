package listen.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-21
 * Time: 12:59
 */
// 使用Mybatis的接口方法，所有接口方法都是类似，只是传入参数和返回值不同
// 可以考虑设计统一的基类，以泛型的方式定义出不同的参数类型、返回类型
public interface BaseMapper<T extends BaseEntity> {


    T selectByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int deleteByPrimaryKey(Integer id);

    T selectOne(T record);

    List<T> selectAll();

    List<T> selectByCondition(T record);

    int deleteByIds(List<Integer> ids);

}
