package dp3;

// Tabulation 
// TC-> O(x*n)
// SC-> O(x)
import java.util.*;
import java.io.*;
public class coin_combinations{
 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int []arr= new int [n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int [] dp= new int [x+1];
        Arrays.fill(dp,1000000007);
         dp[0]=0;
         for(int i=1;i<=x;i++){
             for(int j=0;j<n;j++){
                 if(i>=arr[j]){
                     dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
                 }
             }
         }
         int ans=dp[x]==1000000007?-1:dp[x];
        System.out.println(ans);
 
 
    }
 
}