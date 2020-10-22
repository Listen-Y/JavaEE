/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-27
 * Time: 16:41
 */
public class Test {

    public static void main1(String[] args) {
        //共享数据 因为Thread继承了Runnable接口 重写了其run方法
        // 所以可以直接传入一个继承了thread的类
        //所以执行其run方法时是该改变的同一个变量i
        SharedVariablesThread thread = new SharedVariablesThread();
        Thread a = new Thread(thread, "A");
        Thread b = new Thread(thread, "B");
        Thread c = new Thread(thread, "C");
        Thread d = new Thread(thread, "D");
        a.start();
        b.start();
        c.start();
        d.start();

    }

    public static void main(String[] args) {
        //不共享变量就是初始化多个i
        DoNotShareVariablesThread a = new DoNotShareVariablesThread("A");
        DoNotShareVariablesThread b = new DoNotShareVariablesThread("B");
        DoNotShareVariablesThread c = new DoNotShareVariablesThread("C");
        DoNotShareVariablesThread d = new DoNotShareVariablesThread("D");
        a.start();
        b.start();
        c.start();
        d.start();
    }
}
