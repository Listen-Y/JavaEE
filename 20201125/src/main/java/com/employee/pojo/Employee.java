package com.employee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 8:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private int id;
    private String name;
    private int sex;
    private Date entry;
    private String depart;
    private String phone;

    public Employee(String name, int sex, String depart, String phone) {
        this.name = name;
        this.sex = sex;
        this.depart = depart;
        this.phone = phone;
    }
}
