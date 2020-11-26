package com.employee.dao;

import com.employee.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 8:59
 */
public interface EmployeeMapper {

    List<Employee> select();
    List<Employee> selectLike(@Param("keyWords") String keyWords);
    Employee query(@Param("id") int id);
    int add(Employee employee);
    int delete(@Param("id") int id);
    int update(Map<String, Object> map);
}
