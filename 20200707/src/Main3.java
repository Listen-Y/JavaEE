
import java.util.*;

public class Main3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String p=sc.next();
        String a=sc.next();
        String[] pMoney=p.split("\\.");
        String[] aMoney=a.split("\\.");
        int pTotal=Integer.parseInt(pMoney[0])*17*29+Integer.parseInt(pMoney[1])*29+Integer.parseInt(pMoney[2]);
        int aTotal=Integer.parseInt(aMoney[0])*17*29+Integer.parseInt(aMoney[1])*29+Integer.parseInt(aMoney[2]);
        int sight=1;
        int different=aTotal-pTotal;
        if(different<0){
            different=-different;
            sight=-sight;
        }
        int p1=different/(17*29);
        int p2=(different-p1*17*29)/29;
        int p3=(different-p1*17*29-p2*29);
        p1*=sight;
        System.out.println(p1+"."+p2+"."+p3);
    }
}