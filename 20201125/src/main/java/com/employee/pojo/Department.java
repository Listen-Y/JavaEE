package com.employee.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 15:36
 */
public class Department {

    private static final List<String> departments;

    static {
        departments = new ArrayList<>();
        departments.add("人事部");
        departments.add("开发部");
        departments.add("测试部");
        departments.add("运维部");
    }

    public static List<String> getDepartments() {
        return departments;
    }
}
