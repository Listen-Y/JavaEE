/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-04
 * Time: 15:34
 */

class One {
    public One() {
        System.out.println("One 构造");
    }

    {
        System.out.println("One 实例");
    }

    static {
        System.out.println("One 静态");
    }
}

class Two extends One {
    public Two() {
        System.out.println("Two 构造");
    }

    {
        System.out.println("Two 实例");
    }

    static {
        System.out.println("Two 静态");
    }
}

public class Demo1{

    public static void main(String[] args) {
        System.out.println("开始");
        new Two();
        new Two();
        System.out.println("结束");
    }

}
