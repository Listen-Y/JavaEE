package com.cache8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cache8.service.PersonService;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-08
 * Time: 15:16
 */
@RequestMapping(value = "/per")
@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object get(int id) {
        return service.getPerson(id);
    }

}
