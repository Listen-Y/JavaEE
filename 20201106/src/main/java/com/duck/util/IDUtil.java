package com.duck.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 10:47
 */
public class IDUtil {

    public static String getID() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s.substring(0, s.length() / 4);
    }
}
