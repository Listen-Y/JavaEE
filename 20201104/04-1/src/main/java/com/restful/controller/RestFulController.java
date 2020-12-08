package com.restful.controller;

import com.restful.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 12:11
 */
@Controller
public class RestFulController {

    @RequestMapping(value = "/r1/{n1}/{n2}", method = {RequestMethod.POST})
    public String test1(@PathVariable int n1, @PathVariable String n2, Model model) {
        String result = n1 + n2;
        model.addAttribute("msg", "结果为:" + result);
        return "test";
    }

    @RequestMapping(value = "/r2")
    public String test2(@RequestParam(value = "username") String name, Model model) {
        model.addAttribute("msg", "结果为:" + name);
        return "test";
    }

    @RequestMapping(value = "/r3")
    public String test3(User user, Model model) {
        model.addAttribute("msg", "结果为:" + user.toString());
        return "test";
    }

    @RequestMapping(value = "/r4")
    public String test4(ModelMap modelMap) {
        modelMap.addAttribute("msg", "我是 modelMap");
        return "test";
    }

    @RequestMapping(value = "/r5")
    public ModelAndView test45(ModelAndView modelAndView) {
        modelAndView.addObject("msg", "我是 ModelAndView");
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
