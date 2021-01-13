package com.observer.test;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 19:46
 */
public class Client {

    public static void main(String[] args) {
        //被观察者
        Monitor monitor = new Monitor();

        //观察者
        Student a = new Student("a", true);
        Student b = new Student("b", false);
        Student c = new Student("c", true);
        Student d = new Student("d", false);
        Student e = new Student("e", false);

        monitor.addObserver(a);
        monitor.addObserver(b);
        monitor.addObserver(c);
        monitor.addObserver(d);
        monitor.addObserver(e);

        //老师来了, 班长进行了通知学生
        monitor.notifyObserver();
    }
}
