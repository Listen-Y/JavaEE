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

    @Override
    public List<Employee> select() {
        return employeeMapper.select();
    }

    @Override
    public Employee query(int id) {
        return employeeMapper.query(id);
    }

    @Override
    public int add(Employee employee) {
        return employeeMapper.add(employee);
    }

    @Override
    public int delete(int id) {
        return employeeMapper.delete(id);
    }

    @Override
    public int update(Map<String, Object> map) {
        return employeeMapper.update(map);
    }
}
