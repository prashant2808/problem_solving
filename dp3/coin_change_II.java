package dp3;
class Solution {
  public int change(int amount, int[] coins) {
      int [][] dp= new int [1+coins.length][amount+1];

   for(int i=0;i<=coins.length;i++){
      for(int j=0;j<=amount;j++)if(j==0)dp[i][j]=1;
   }
   for(int i=1;i<=coins.length;i++){
     for(int j=1;j<=amount;j++){
       if(coins[i-1]>j){
         dp[i][j]=dp[i-1][j];
       }
       else {
         dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
       }

     }
   }
   return  dp[coins.length][amount];
       
  }
}