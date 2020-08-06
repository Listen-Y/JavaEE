import java.util.*;
public class Main3{
    public static long bag(int []weight,int n,int sum){
        long[] dp =new long[sum+1];
        dp[0]=1;
        int i,j;
        for(i=0;i<n;i++){
            for(j=sum;j>=weight[i];j--){
                dp[j]=dp[j-weight[i]]+dp[j];
            }
        }
        return dp[sum];
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int sum=s.nextInt();
        int i;
        int[] arr =new int[n];
        for(i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println(bag(arr,n,sum));
    }
}
