/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-27
 * Time: 22:28
 */
public class SharedVariablesThread extends Thread {

    private int i = 5;

    @Override
    public void run() {

        //如果共享了变量这里就不能
        System.out.println(Thread.currentThread().getName() + "计算出i=" + i--);

    }
}
