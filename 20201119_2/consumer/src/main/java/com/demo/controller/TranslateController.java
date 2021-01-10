package com.demo.controller;

import com.demo.service.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-20
 * Time: 9:51
 */
@RestController
public class TranslateController {

    @Autowired
    Translation translation;

    @RequestMapping("/tran/{str}")
    public String tran(@PathVariable("str")String str) {
        return translation.getTranslation(str);
    }
}
