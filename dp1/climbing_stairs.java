// space optimization
class Solution {
  public int climbStairs(int n) {
    if(n==0||n==1||n==2)return n;
      int prev1=2;
      int prev2=1;
      for(int i=3;i<=n;i++)
      {
         int curr=prev1+prev2;
         prev2=prev1;
         prev1=curr;
      }  
      return prev1;
}
}
/*   
// tabulation


class Solution {
  public int climbStairs(int n) {
    if(n==0||n==1||n==3)return n;
      int [] dp = new int [n+1];
      dp[0]=0;
      dp[1]=1;
      dp[2]=2;
      for(int i=3;i<=n;i++)
      {
        dp[i]=dp[i-1]+dp[i-2];
      }  
      return dp[n];
}
}
 // recursion +memoization

 
 class Solution {
  public int climbStairs(int n) {
      int [] dp = new int [n+1];
      Arrays.fill(dp,-1);   
      return steps(n,dp);   
}
int steps(int n,int [] dp)
{
  if(n<=2)return n;
  if(dp[n]!=-1)return dp[n];
  dp[n]=steps(n-1,dp)+steps(n-2,dp);
  return dp[n];
}

}

*/