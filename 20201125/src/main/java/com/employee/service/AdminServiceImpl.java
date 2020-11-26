package com.employee.service;

import com.employee.dao.AdminMapper;
import com.employee.pojo.Admin;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 9:27
 */
public class AdminServiceImpl implements AdminService {

    AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     * 按名字查询管理员
     * @param name
     * @return
     */
    @Override
    public Admin query(String name) {
        return adminMapper.query(name);
    }
}
