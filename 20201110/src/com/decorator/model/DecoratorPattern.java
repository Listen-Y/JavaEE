package com.decorator.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 19:27
 */
public class DecoratorPattern {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("我想要6元的手抓饼");
        //首先需要一个面饼
        Cake cake = new Cake();
        Flour six = new SixYuanCake(cake);
        six.display();

        System.out.println("\n=============================");

        System.out.println("我想要10元的鸡翅手抓饼");
        //首先需要一个面饼
        Cake cake1 = new Cake();
        Flour ten = new TenYuanCake(cake1);
        ten.display();
    }
}


//抽象构件面粉
interface Flour {

    void display();
}

//具体构件饼
class Cake implements Flour {

    public void display() {
        System.out.print("面饼-");
    }
}

//初始装饰形成四块钱的手抓饼
class FourYuanCake extends Cake implements Flour {

    protected Cake cake;

    public FourYuanCake(Cake cake) {
        System.out.println("煎一个鸡蛋...");
    }

    public void display() {
        super.display();
        //对面饼进行装饰
        System.out.print("装饰加鸡蛋-");
    }
}

//装饰形成五块钱的手抓饼
class FiveYuanCake extends FourYuanCake implements Flour {

    public FiveYuanCake(Cake cake) {
        super(cake);
        System.out.println("煎一个火腿肠...");
    }

    public void display() {
        super.display();
        //对同一个面饼装饰成四元的手抓饼进行再次装饰
        System.out.print("装饰加火腿肠-");
    }
}

//装饰形成六块钱的手抓饼
class SixYuanCake extends FiveYuanCake implements Flour {

    public SixYuanCake(Cake cake) {
        super(cake);
        System.out.println("烤一根腊肠...");
    }

    public void display() {
        super.display();
        //对同一个面饼装饰成四元的手抓饼进行再次装饰
        System.out.print("装饰加腊肠-");
    }
}

//我要装饰面饼加鸡翅直接形成10元的
class TenYuanCake extends Cake implements Flour {

    protected Cake cake;

    public TenYuanCake(Cake cake) {
        System.out.println("煎一个鸡翅...");
    }

    public void display() {
        super.display();
        //对面饼进行装饰
        System.out.print("装饰加鸡翅-");
    }
}