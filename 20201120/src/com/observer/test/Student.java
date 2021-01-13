package com.observer.test;

import com.observer.Observer;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 19:38
 */
/*
学生是观察者
 */
public class Student implements Observer {

    private String name;
    private boolean studying; //true表示正在学习, false表示在玩

    public Student(String name, boolean studying) {
        this.name = name;
        this.studying = studying;
    }

    @Override
    public void update() {

        if (studying) {
            System.out.println(name + "依旧学习");
        } else {
            System.out.println(name + "吓了一跳然后开始学习");
            this.studying = true;
        }
    }
}
