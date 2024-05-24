
// TABULATION
// TC-> O(n*x)
// sc-> O(x)

import java.util.*;
import java.io.*;
public class Minimizing_coins{
 
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

// RECURSION + MEMOIZATION 
// TC-> O(n*x)
 // SC-> O(n*x)
 /* 
import java.util.*;
public class Minimizing_coins {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    int x=sc.nextInt();
    int [] coins= new int [n];
    for(int i=0;i<n;i++)coins[i]=sc.nextInt();
    int [][] dp= new int [n][x+1];
    for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
     int result=minimize(n-1,coins,x,dp);
     if(result==(int)1e7)System.out.println(-1);
     else 
     System.out.println(result);
  }
  static int minimize(int i,int[] coins, int x,int [][] dp){
    if(x==0)return 0;
    if(i<0||x<=0){
      return x==0?0:(int)1e7;
    }
    if(dp[i][x]!=-1)return dp[i][x];
    // pick  and move to next coin 
    int a=1+minimize(i-1,coins,x-coins[i],dp);
    // pick and again take same coin
    int b=1+minimize(i,coins,x-coins[i],dp);
    // do not pick and move to next coin
    int c=minimize(i-1,coins,x,dp);
    return dp[i][x]= Math.min(a,Math.min(b,c));
  }
  
}
*/