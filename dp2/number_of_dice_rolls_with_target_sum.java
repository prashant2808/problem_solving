package dp2;
 
// 
// TABULATION
// TC-> O(n*target*k)
// SC-> O(n*target)
class Solution {
  public int numRollsToTarget(int n, int k, int target) {
      int [][] dp= new int [n+1][target+1];
      dp[0][0]=1;
      for(int i=1;i<=n;i++){
          for(int j=1;j<=target;j++){   
              int curr=0;
              for(int x=1;x<=k;x++){
                  if(j-x>=0)
                   curr=(curr+dp[i-1][j-x])%1000000007;
              }
              dp[i][j]=curr;
          }
      }
      
      return  dp[n][target];
  }
}
// RECURSION +MEMOIZATION
// TC-> O(n*target*k)
// SC-> O(n*target) { auxilary space} +O(n) {stack space}
class Solution {
  public int numRollsToTarget(int n, int k, int target) {
       int [][] dp= new int [n+1][target+1];
       for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
      return findways(dp,n,k,target);
  }
  int findways(int [][]dp,int n,int k,int target)
  {
       
      if(n==0||target<=0){
         if(target==0&&n==0)return 1;
       return 0;
      }
      if(dp[n][target]!=-1)return dp[n][target];
      int curr=0;
      for(int i=1;i<=k;i++)
      {
          curr=(curr+findways(dp,n-1,k,target-i))%1000000007;
      }
      dp[n][target]=curr;
      return curr;
  }

  
}
