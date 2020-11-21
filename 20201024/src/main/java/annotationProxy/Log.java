package annotationProxy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-24
 * Time: 13:58
 */
//添加注解表示这是一个切面
@Aspect
public class Log {

    //添加注解, 配置切入点
    @Before("execution(* myProxy.Dao.*(..))")
    public void before() throws Throwable {
        System.out.println("=====方法执行前=====");
    }

    @After("execution(* myProxy.Dao.*(..))")
    public void after() {
        System.out.println("=====方法执行后=====");
    }


    //环绕,使用这个注解可以给定一个参数, 去代表我们的切入点
    @Around("execution(* myProxy.Dao.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        //这个代表去执行这个方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
    }
}
