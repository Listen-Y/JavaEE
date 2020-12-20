package com.facade;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-12
 * Time: 21:51
 */
public class Menu {

    private Dish pork;
    private Dish mutton;
    private Dish beef;
    private Dish fish;
    private Dish dumpling;
    private Dish coke;
    private Dish orange;

    public Menu() {
        init();
    }

    private void init() {
        pork = new Pork();
        mutton = new Mutton();
        beef = new Beef();
        fish = new Fish();
        dumpling = new Dumpling();
        coke = new Coke();
        orange = new Orange();
    }

    //套餐A
    public void setMealA() {
        System.out.println("===套餐A: ");
        pork.show();
        mutton.show();
        beef.show();
        coke.show();
    }

    //套餐B
    public void setMealB() {
        System.out.println("===套餐B:");
        fish.show();
        dumpling.show();
        orange.show();
    }

    //套餐C
    public void setMealC() {
        System.out.println("===套餐C:");
        beef.show();
        fish.show();
        pork.show();
    }
}


abstract class Dish {

    protected String name;

    abstract public void show();
}

class Pork extends Dish {

    public Pork() {
        name = "炖猪肉";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

class Mutton extends Dish {

    public Mutton() {
        name = "炖羊肉";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

class Beef extends Dish {

    public Beef() {
        name = "炖牛肉";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

class Fish extends Dish {

    public Fish() {
        name = "清真鱼肉";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

class Dumpling extends Dish {

    public Dumpling() {
        name = "水饺";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

class Coke extends Dish {

    public Coke() {
        name = "可乐";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}

class Orange extends Dish {

    public Orange() {
        name = "橙汁";
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}
