import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {


        Thread thread = new Thread() {
            @Override
            public void run() {

                while (!Thread.currentThread().isInterrupted()) {
                    Calendar calendar = new GregorianCalendar(); // 获取当前系统时间

                    String am_pm = "AM";
                    int houer = calendar.get(Calendar.HOUR); // 或得时
                    int minute = calendar.get(Calendar.MINUTE); // 或得分
                    int second = calendar.get(Calendar.SECOND); // 获得秒

                    if (calendar.get(Calendar.AM_PM) == Calendar.PM) { //判断是上午还是下午
                        am_pm = "PM";
                    }

                    String time = am_pm + " " + houer + ":" +minute + ":" + second;
                    System.out.println(time);

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("计时结束");
                        break;
                    }
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
