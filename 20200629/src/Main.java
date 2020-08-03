import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s="";
        while((s=bf.readLine())!=null){
            int n=Integer.parseInt(s);
            String[] ss =bf.readLine().split(" ");
            int[] a =new int[n];
            for (int i = 0; i < ss.length; i++) {
                a[i]=Integer.parseInt(ss[i]);
            }
            String[] sss =bf.readLine().split(" ");
            int[] b =new int[n];
            for (int i = 0; i < sss.length; i++) {
                b[i]=Integer.parseInt(sss[i]);
            }
            float suma=0;
            for (int i = 0; i < b.length; i++) {
                if(90<=b[i]&&b[i]<=100) suma+=4.0*a[i];
                if(85<=b[i]&&b[i]<=89) suma+=3.7*a[i];
                if(82<=b[i]&&b[i]<=84) suma+=3.3*a[i];
                if(78<=b[i]&&b[i]<=81) suma+=3.0*a[i];
                if(75<=b[i]&&b[i]<=77) suma+=2.7*a[i];
                if(72<=b[i]&&b[i]<=74) suma+=2.3*a[i];
                if(68<=b[i]&&b[i]<=71) suma+=2.0*a[i];
                if(64<=b[i]&&b[i]<=67) suma+=1.5*a[i];
                if(60<=b[i]&&b[i]<=63) suma+=1.0*a[i];
                if(b[i]<60)  suma+= 0;
            }
            float sum=0;
            for (int i = 0; i < b.length; i++) {
                sum+=a[i];
            }
            System.out.println(String.format("%.2f", suma/sum));
        }
    }
}