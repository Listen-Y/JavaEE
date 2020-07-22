import java.math.BigInteger;
import java.util.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        in.close();
        int count = 0;
        while (x0 != 0 && count <= 300000) {
            x0 = ((x0 << 1) + 1) % 1000000007;
            count++;
        }


        //因为最多只有加俩次的2x+1
        //总次数取余3 只要不是0 就给res加一
        //3 3 3 2
        //3 3 3 2 2

        //所以当除以三 为整数的话  对于加二有没有影响
        // 如果除以三不是整数  可能余数为1 或者 2  此时加2  就会使结果多一次 正和前面取余所说的样子
        int res = (count + 2) / 3;

        System.out.println(res > 100000 ? -1 : res);
    }
}


  /*  public int addAB(int A, int B) {
        // write code here
        BigInteger big1 = new BigInteger(String.valueOf(A));
        BigInteger big2 = new BigInteger(String.valueOf(B));
        big1 = big1.add(big2);
        return Integer.parseInt(big1.toString());
    }*/
