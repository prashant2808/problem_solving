package dp3;

// tabulation
class Solution {
  int x=1000000007;
  public int coinChange(int[] coins, int amount) {
      int [][] dp=new int [1+coins.length][amount+1];
      for(int i=0;i<=coins.length;i++){
          for(int j=0;j<=amount;j++){
              dp[i][j]=(j==0)?0:x;
          }
      }
      for(int i=1;i<=amount;i++){
          for(int j=1;j<=coins.length;j++){
              if(coins[j-1]>i){
                  dp[j][i]=dp[j-1][i];
              }
              else {
                  dp[j][i]=Math.min(dp[j-1][i],1+dp[j][i-coins[j-1]]);
              }
          }
      }
      return dp[coins.length][amount]==x?-1:dp[coins.length][amount];
       
      
  } 
}
   
// recursion + memoization 
/*  
class Solution {
  public int coinChange(int[] coins, int amount) {
      Arrays.sort(coins);
      int [][] dp= new int [coins.length][amount+1];
      for(int i=0;i<coins.length;i++)Arrays.fill(dp[i],-1);
      int ans= count(coins,coins.length-1,amount,dp);
      return ans==(int)1e7?-1:ans;
  }
  int count(int [] coins,int i,int amount,int [][] dp){
      if(i<0){
          if(amount==0)return 0;
          return (int)1e7;
      }
      if(amount==0)return 0;
      if(amount<0)return (int)1e7;
      if(dp[i][amount]!=-1)return dp[i][amount];
      //  way 1-> pick the current element and dont move to next coin
      int x1=1+count(coins,i,amount-coins[i],dp);
      // way 2-> pick the current element and move to next coin
      int x2=1+count(coins,i-1,amount-coins[i],dp);
      // way 3 -> dont pick the current coin and move next 
      int x3=count(coins,i-1,amount,dp); 
      return  dp[i][amount]= Math.min(x1,Math.min(x2,x3));
  }
}
*/