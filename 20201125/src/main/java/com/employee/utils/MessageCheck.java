package com.employee.utils;

import com.employee.pojo.Department;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 15:23
 */
public class MessageCheck {

    public static String checkAll(String name, String sex, String depart, String phone) {

        if (!MessageCheck.checkName(name)) return "姓名格式有误";
        if (!MessageCheck.checkSex(sex)) return "性别格式有误";
        if (!MessageCheck.checkDepart(depart)) return "部门所属有误";
        if (!MessageCheck.checkPhone(phone)) return "电话号码格式有误";
        return "";
    }

    private static boolean checkName(String name) {

        if (name.trim().length() == 0) return false;
        //如果名字里有数字即为不符合
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 48 && c <= 57) return false;
        }
        return true;
    }

    private static boolean checkSex(String sex) {
        //检查性别是否合法
        return "男".equals(sex) || "女".equals(sex)
                || "man".equalsIgnoreCase(sex) || "girl".equalsIgnoreCase(sex);
    }

    private static boolean checkDepart(String depart) {
        //检查部门是否合法
        List<String> departments = Department.getDepartments();
        return departments.contains(depart);
    }

    private static boolean checkPhone(String phone) {
        //检查电话号码是否合法
        if (phone.length() != 11) return false;
        for (int i = 0; i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (c < 48 || c > 57) return false;
        }
        return true;
    }
}
