package com.job;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-18
 * Time: 16:45
 */
public class Test {


    /**
     * 需求: 获取明天日期
     *
     * @return
     * @throws InterruptedException
     */
    public Date nextDate() throws InterruptedException {
        Thread.sleep(1000*60*60*24);
        return new Date();
    }
}
