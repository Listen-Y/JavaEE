/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-13
 * Time: 9:50
 */
public class Demo {

    public static void main(String[] args) {
        Service service = new Service();
        //其中一和二会有重排序问题, 三和四也会有重排序问题
        //但是上锁了就不会了
    }
}

class Service {

    private int i = 0;
    private boolean key = false;

    public synchronized void write() {
        i = 1;         //1
        key = true;    //2
    }

    public synchronized int read() {
        int a = 0;
        if (key) {      //3
            a = i * i;  //4
        }
        return a;
    }

}
