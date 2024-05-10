 // Tabulation

class Solution {
  public int numSquares(int n) {
      int [] dp= new int [n+1];
      for(int i=0;i<=n;i++)dp[i]=i;
      for(int i=1;i<=n;i++){
          for(int j=1;j*j<=i;j++){
              dp[i]=Math.min(dp[i],1+dp[i-j*j]);
          }

      }
      return dp[n];
  }
}
// recursion + memoization
class Solution {
  public int numSquares(int n) {
      int [] dp= new int [n+1];
      Arrays.fill(dp,-1);
      return find(n,dp);

  }
  int find(int n,int []dp){
      if(n<0)return Integer.MAX_VALUE;
      if(n==0)return 0;
      if(dp[n]!=-1)return dp[n];
      int ans=Integer.MAX_VALUE;
      for(int i=1;i*i<=n;i++){
          ans=Math.min(ans,1+find(n-i*i,dp));
           
      }
      return  dp[n]=ans;
  }
}