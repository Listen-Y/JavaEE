package com.employee.controller;

import com.employee.pojo.Employee;
import com.employee.service.EmployeeService;
import com.employee.utils.MessageCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 12:16
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    /**
     * 获取所有员工数据, 返回modelAndView
     * @param model
     * @return
     */
    @RequestMapping("/success")
    public String success(Model model) {
        System.out.println("[DEBUG] success");

        model.addAttribute("list", employeeService.select());
        return "showAll";
    }

    /**
     * 添加一个员工
     * @param name
     * @param sex
     * @param depart
     * @param phone
     * @return
     */
    @RequestMapping(value = "/add", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String add(String name, String sex, String depart, String phone) {
        name = name.trim();
        sex = sex.trim();
        depart = depart.trim();
        phone = phone.trim();
        //检查合法性
        String error = MessageCheck.checkAll(name, sex, depart, phone);
        if (error.length() > 0) {
            return error;
        }
        //进行数据库操作实现增加
        int sexNum = 1;
        if ("girl".equalsIgnoreCase(sex) || "女".equals(sex)) {
            sexNum = 0;
        }
        Employee employee = new Employee(name, sexNum, depart, phone);
        employeeService.add(employee);
        return "OK";

    }

    /**
     * 方便页面跳转
     * @return
     */
    @RequestMapping("/addEmployee")
    public String newEmployee() {
        return "add";
    }

    /**
     * 支持模糊查询
     * @param keyWords
     * @param model
     * @return
     */
    @RequestMapping("/findLike")
    public String findLike(String keyWords, Model model) {
        List<Employee> list = employeeService.selectLike("%" + keyWords + "%");
        if (list.size() == 0) model.addAttribute("ERROR", "未找到");
        model.addAttribute("list", list);
        return "showAll";
    }

    /**
     * 根据id得到员工数据, 然后返回修改数据页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id")int id, Model model) {
        Employee employee = employeeService.query(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    /**
     * 执行修改员工数据的操作
     * @param id
     * @param name
     * @param sex
     * @param depart
     * @param phone
     * @return
     */
    @RequestMapping(value = "/update", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String update(int id, String name, String sex, String depart, String phone) {
        name = name.trim();
        sex = sex.trim();
        depart = depart.trim();
        phone = phone.trim();
        //数据检验
        String error = MessageCheck.checkAll(name, sex, depart, phone);
        if (error.length() > 0) {
            return error;
        } else {

        int sexNum = 1;
        if ("girl".equalsIgnoreCase(sex) || "女".equals(sex)) {
            sexNum = 0;
        }

        Employee query = employeeService.query(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        if (!query.getName().equals(name)) map.put("name", name);
        if (query.getSex() != sexNum) map.put("sex", sexNum);
        if (!query.getDepart().equals(depart)) map.put("depart", depart);
        if (!query.getPhone().equals(phone)) map.put("phone", phone);
        if (map.size() <= 1) return "OK";


        int update = employeeService.update(map);
        System.out.println("[DEBUG]update " + update);
        return "OK";
        }
    }

    /**
     * 查看某个员工的详细信息
     * @param employeeId
     * @param model
     * @return
     */
    @RequestMapping(value = "/query")
    public String query(int employeeId, Model model) {
        Employee employee = employeeService.query(employeeId);
        model.addAttribute("employee", employee);
        return "detials";
    }

    /**
     * 删除一个员工
     * @param employeeId
     * @return
     */
    @RequestMapping("/delete")
    public String delete(int employeeId) {
        int delete = employeeService.delete(employeeId);
        System.out.println("[DEBUG] " + delete);
        return "redirect:/success";

    }
}
