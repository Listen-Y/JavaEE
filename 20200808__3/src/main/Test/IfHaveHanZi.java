/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-15
 * Time: 20:13
 */
public class IfHaveHanZi {
    public static void main(String[] args) {
        String s = "listen";
        String s1 = "哈哈哈";
        if (s.getBytes().length == s.length()) {
            System.out.println("无汉字");
        } else {
            System.out.println("有汉字");
        }
        if (s1.getBytes().length == s1.length()) {
            System.out.println("无汉字");
        } else {
            System.out.println("有汉字");
        }
    }
}
