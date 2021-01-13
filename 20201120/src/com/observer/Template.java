package com.observer;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 22:10
 */
public class Template {

    public static void main(String[] args) {
        GameTemplate lol = new LOL("listen");
        GameTemplate cf = new CF("james");
        GameTemplate dota = new DOTA("kobe");

        lol.templateMethod();
        System.out.println("*");
        cf.templateMethod();
        System.out.println("*");
        dota.templateMethod();
    }
}



abstract class GameTemplate {
    protected String username;

    public GameTemplate(String username) {
        this.username = username;
    }

    /*
        加载游戏
         */
    abstract public void init();
    /*
    开始游戏
     */
    abstract public void begin();
    /*
    结束游戏
     */
    abstract public void end();


    /*
    模板方法,被final修饰, 但是不可与abstract同时修饰,意义会冲突
    其可以被继承, 但是不可以进行重写扩展
     */
    final public void templateMethod() {


        /*
        要修改必须在定义这个方法原始地方修改
         */
        this.init();
        this.begin();
        this.end();
    }
}

class LOL extends GameTemplate {

    public LOL(String username) {
        super(username);
    }

    @Override
    public void init() {
        System.out.println(username + "下载了LOL");
    }

    @Override
    public void begin() {
        System.out.println(username + "开始LOL");
    }

    @Override
    public void end() {
        System.out.println(username + "结束LOL");
    }
}

class CF extends GameTemplate {

    public CF(String username) {
        super(username);
    }

    @Override
    public void init() {
        System.out.println(username + "下载了CF");
    }

    @Override
    public void begin() {
        System.out.println(username + "开始CF");
    }

    @Override
    public void end() {
        System.out.println(username + "结束CF");
    }
}

class DOTA extends GameTemplate {

    public DOTA(String username) {
        super(username);
    }

    @Override
    public void init() {
        System.out.println(username + "下载了DOTA");
    }

    @Override
    public void begin() {
        System.out.println(username + "开始DOTA");
    }

    @Override
    public void end() {
        System.out.println(username + "结束DOTA");
    }
}
