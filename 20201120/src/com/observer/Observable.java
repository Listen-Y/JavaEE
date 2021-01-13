package com.observer;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 19:32
 */

/*
被观察者接口
 */
public interface Observable {

    /*
    添加观察者
     */
    void addObserver(Observer observer);
    /*
    删除观察者
     */
    void deleteObserver(Observer observer);
    /*
    通知观察者
     */
    void notifyObserver();
}
