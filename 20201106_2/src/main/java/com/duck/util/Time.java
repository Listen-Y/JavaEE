package com.duck.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 11:05
 */
public class Time {

    public static Timestamp getTime() {
        return new Timestamp(new Date().getTime());
    }
}
