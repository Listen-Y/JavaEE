package com.employee.service;

import com.employee.dao.EmployeeMapper;
import com.employee.pojo.Employee;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 9:29
 */
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeMapper employeeMapper;

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<Employee> select() {
        return employeeMapper.select();
    }

    /**
     * 按id查找员工
     * @param id
     * @return
     */
    @Override
    public Employee query(int id) {
        return employeeMapper.query(id);
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public int add(Employee employee) {
        return employeeMapper.add(employee);
    }

    /**
     * 按照id编号删除一个员工
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        return employeeMapper.delete(id);
    }

    /**
     * 修改员工信息, map中存储要修改的值
     * @param map
     * @return
     */
    @Override
    public int update(Map<String, Object> map) {
        return employeeMapper.update(map);
    }

    /**
     * 支持模糊查询员工
     * @param keyWords
     * @return
     */
    @Override
    public List<Employee> selectLike(String keyWords) {
        return employeeMapper.selectLike(keyWords);
    }
}
