package com.facade;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-12
 * Time: 22:10
 */
public class Client {

    public static void main(String[] args) {
        //menu就好比外观
        Menu menu = new Menu();

        //通过外观menu去访问菜品
        menu.setMealA();
        menu.setMealB();
        menu.setMealC();
    }
}
