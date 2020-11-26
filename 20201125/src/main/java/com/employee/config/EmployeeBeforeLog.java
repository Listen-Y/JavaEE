package com.employee.config;


import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 19:54
 */
public class EmployeeBeforeLog implements MethodBeforeAdvice {

    static Logger logger = Logger.getLogger(EmployeeBeforeLog.class);

    @Override
    public void before(Method method, Object[] objects, Object o) {
        logger.error("方法名:" + method.getName() + " 参数:"+ Arrays.toString(objects)
                +" 目标:"+o);
    }
}
