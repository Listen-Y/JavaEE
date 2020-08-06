import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            double sum1=factorial(n);
            double sum2=count(n);
            double result=(sum2/sum1)*100; //计算成%的形式
            System.out.println(String.format("%.2f",result)+"%");
        }
    }
    //计算所有人都抽不到奖的情况：错排算法
    private static double count(int n) {
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else {
            return (n-1)*(count(n-1)+count(n-2));
        }
    }

    //计算阶乘：迭代写法
    private static double factorial(int n) {
        double sum=1;
        while(n>1){
            sum=sum*n;
            n--;
        }
        return sum;
    }
}