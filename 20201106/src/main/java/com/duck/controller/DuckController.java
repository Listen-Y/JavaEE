package com.duck.controller;

import com.duck.pojo.Duck;
import com.duck.service.DuckService;
import com.duck.util.IDUtil;
import com.duck.util.Time;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 14:44
 */

@Controller
@RequestMapping("/duck")
public class DuckController {

    private final DuckService duckService;

    public DuckController(@Qualifier("duckService") DuckService duckService) {
        this.duckService = duckService;
    }

    //展示所有鸭子
    @RequestMapping("/all")
    public String getAllDuck(Model model) {
        List<Duck> list = duckService.select();
        model.addAttribute("list", list);
        return "allDuck";
    }

    //删除鸭子
    @RequestMapping("/delete")
    public String delete(String duckID) {
        duckService.delete(duckID);
        return "redirect:/duck/all";
    }

    //修改鸭子
    @RequestMapping("/update/{duckID}/{key}")
    public String update(Duck duck, @PathVariable String duckID, @PathVariable int key, Model model) {
        if (key == 1) {
            Duck duck1 = duckService.selectOne(duckID);
            model.addAttribute("duck", duck1);
            return "updateDuck";
        }
        duckService.update(duck);
        return "redirect:/duck/all";
    }

    //模糊查找鸭子
    @RequestMapping("/like")
    public String like(String keyWords, Model model) {
        List<Duck> list = duckService.selectByLike("%" + keyWords + "%");
        if (list.size() == 0) {
            model.addAttribute("ERROR", "未找到");
        } else {
            model.addAttribute("list", list);
        }
        return "allDuck";
    }

    //增加一个鸭子
    @RequestMapping("/add/{key}")
    public String add(Duck duck, @PathVariable int key) {
        if ( key == 1) {
            //只需进行跳转
            return "addDuck";
        }
        duck.setId(IDUtil.getID());
        duck.setBirthday(Time.getTime());
        duckService.insert(duck);
        return "redirect:/duck/all";
    }

    //范围查找鸭子
    @RequestMapping("/range/{key}")
    public String range(@PathVariable int key, HttpServletRequest request, Model model) {
        if (key == 1) {
            return "range";
        } else {
            String minHeight = request.getParameter("minHeight");
            String maxHeight = request.getParameter("maxHeight");
            String minWeight = request.getParameter("minWeight");
            String maxWeight = request.getParameter("maxWeight");
            System.out.println("***" + minHeight + "," + maxHeight + "," + minWeight + "," + maxWeight);
            Map<String, Object> map = new HashMap<String, Object>();
            if (!(minHeight == null) && !minHeight.equals("")) {
                map.put("minHeight", minHeight);
            }
            if (!(maxHeight == null) && !maxHeight.equals("")) {
                map.put("maxHeight", maxHeight);
            }
            if (!(minWeight == null) && !minWeight.equals("")) {
                map.put("minWeight", minWeight);
            }
            if (!(maxWeight == null) && !maxWeight.equals("")) {
                map.put("maxWeight", maxWeight);
            }

            List<Duck> list = duckService.selectByRange(map);
            model.addAttribute("list", list);
            return "allDuck";
        }
    }


}
