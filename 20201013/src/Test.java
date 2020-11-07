/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-13
 * Time: 23:48
 */

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
public class Test {

    public static void main(String[] args) throws MyException {
        throw new MyException("aa");
        new Thread(new Runnable() {

            //@lombok.SneakyThrows
            @Override
            public void run()  {
                throw new MyException("ERROR");
            }
        }).setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            //@lombok.SneakyThrows
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                throw new MyException(e.getMessage());
            }
        });
    }
}
