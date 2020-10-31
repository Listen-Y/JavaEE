/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-09
 * Time: 22:54
 */
public class Test {

    /*
    public T get() {
        //获取当前线程
        Thread t = Thread.currentThread();
        //在map中找到当前线程对应的map数据
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            //找到就获取其键值对
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                //返回键值对的value
                T result = (T)e.value;
                return result;
            }
        }
        //返回默认值
        return setInitialValue();
    }

    public void set(T value) {
        //获取当前线程
        Thread t = Thread.currentThread();
        //获取当前线程的map
        ThreadLocalMap map = getMap(t);
        if (map != null)
            map.set(this, value);
        else
            createMap(t, value);
    }
     */

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        if (threadLocal.get() == null) {
            System.out.println("未设置值");
            threadLocal.set("我是菜鸟");
        }
        System.out.println(threadLocal.get());

    }
}
