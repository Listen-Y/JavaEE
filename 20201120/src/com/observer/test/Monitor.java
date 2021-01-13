package com.observer.test;

import com.observer.Observable;
import com.observer.Observer;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 19:36
 */

/*
班长是被观察者
 */
public class Monitor implements Observable {

      /*
      有很多的观察者去观察被观察者
     */
    private Vector<Observer> students;

    public Monitor() {
        this.students = new Vector<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.students.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.students.remove(observer);
    }

    @Override
    public void notifyObserver() {
        System.out.println("老师来了!!!");
        for (Observer observer : this.students
             ) {
            observer.update();
        }
    }

}
