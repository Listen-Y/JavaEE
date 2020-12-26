
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-16
 * Time: 16:14
 */
public class Main {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            int min = 0;
            int max = 1;
            while (max <= num) {
                int temp = max + min;
                min = max;
                max = temp;
            }
            System.out.println(Math.min(num - min, max - num));
        }
    }

    public static void main2(String[] args) {
        System.out.println(getInt() + "*");
    }

    private static int getInt() {

        String a[] = new String[50];
        String[] as = new String[50];
        Object ass[] = new String[50];

        //不仅String是final型的 StringBuffer也是fina型的
        //关于为什么StringBuffer是final值却可以改变这个，
        // 想起之前做过的笔记:final修饰的成员变量为基本数据类型时，赋值后无法改变。
        // 当final修饰的为引用变量时，在赋值后其指向地址无法改变，但对象内容可以改变。
        // 感觉应该有一定关系 另外，对于该题，final修饰类只是限定类不可被继承，而非限定了其对象是否可变

        int num = 3;
        try {
            num++;
            return num;
        } finally {
            num++;
            System.out.println(num);
            return num;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(20);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (needDelete(obj)) {
                iterator.remove();
            }
        }

        System.out.println(list);

    }

    private static boolean needDelete(Object obj) {

        String s = (String)obj;
        return s.equals("bbb");
    }
}
