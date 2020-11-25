package com.employee.service;

import com.employee.pojo.Admin;
import com.employee.pojo.Employee;
import com.employee.utils.MD5Utils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 10:07
 */
public class EmployeeServiceImplTest extends TestCase {

    private static final EmployeeService employeeService;

    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        employeeService = applicationContext.getBean("employeeServiceImpl", EmployeeService.class);

    }

    public void testSelect() {
        for (Employee employee : employeeService.select()) {
            System.out.println(employee);
        }
    }

    /* public Employee(String name, int sex, String depart, String phone) {*/
    public void testQuery() {
        Employee employee = employeeService.query(2);
        System.out.println(employee);
    }

    public void testAdd() {
        Employee employee = new Employee("bike", 1, "人事部", "11111111111");
        employeeService.add(employee);
    }

    public void testDelete() {
        employeeService.delete(2);
    }

    public void testUpdate() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
/*        map.put("name", "faker");*/
        map.put("sex", 0);
        map.put("depart", "管理部");
        map.put("phone", "99999999999");
        System.out.println(employeeService.update(map));
    }
}