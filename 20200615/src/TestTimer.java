public class TestTimer {

    public static void main(String[] args) {

        Timer timer = new Timer();

       timer.shedule(new Runnable() {
           @Override
           public void run() {
               System.out.println("haha");
               timer.shedule(this, 2000);
           }
       }, 2000);
    }
}
