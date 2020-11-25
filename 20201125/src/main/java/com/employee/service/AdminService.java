package com.employee.service;

import com.employee.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 8:57
 */
public interface AdminService {

    Admin query(String name);

}
