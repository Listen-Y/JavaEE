import java.math.BigDecimal;
import java.math.BigInteger;

public class Test {
    public static void main1(String[] args) {
        BigInteger a = new BigInteger("222222222222222222222222");
        BigInteger b = new BigInteger("333333333333333333333333");
        System.out.println("add >>> " + a.add(b));
        System.out.println("subtract >>> " + a.subtract(b));
        System.out.println("multiply >>> " + a.multiply(b));
        System.out.println("divide >>> " + a.divide(b));
        System.out.println("divideAndRemainder[0] >>> " + a.divideAndRemainder(b)[0]);
        System.out.println("divideAndRemainder[1] >>> " + a.divideAndRemainder(b)[1]);
    }

    public static void main2(String[] args) {
             BigDecimal a = new BigDecimal(2);
             BigDecimal b = new BigDecimal(2.3);
             BigDecimal c = new BigDecimal("2.3");
             System.out.println(a);
             System.out.println(b);
             System.out.println(c);
    }

    public static void main(String[] args) {
             BigDecimal a = new BigDecimal("10.111111111111111111111");
             BigDecimal b = new BigDecimal("3.7777777777777777777777");
             System.out.println("add >>> " + a.add(b));
             System.out.println("subtract >>> " + a.subtract(b));
             System.out.println("multiply >>> " + a.multiply(b));
             System.out.println("divide >>> " + a.divide(b, 2, BigDecimal.ROUND_HALF_UP));
             System.out.println("divideAndRemainder[0] >>> " + a.divideAndRemainder(b)[0]);
             System.out.println("divideAndRemainder[1] >>> " + a.divideAndRemainder(b)[1]);
             System.out.println("四舍五入保留一位小数 >>> " + a.setScale(1, BigDecimal.ROUND_HALF_UP));
             System.out.println("四舍五入保留一位小数 >>> " + b.setScale(1, BigDecimal.ROUND_HALF_UP));
    }
}
