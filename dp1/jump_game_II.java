 // recursion + memoization
 class Solution {
  public int jump(int[] nums) {
      int [] dp= new int [nums.length];
      Arrays.fill(dp,-1);
     return find(0,nums,dp); 
  }
  int find(int i,int [] nums,int [] dp){
      if(i==nums.length-1)return 0;
      if(dp[i]!=-1)return dp[i];
      int min=(int)1e7;
      for(int j=1;j<=nums[i];j++){
          if(i+j<nums.length){
              min=Math.min(min,1+find(i+j,nums,dp));
          }
      }
      return dp[i]=min;
  }
}

// tabulation

class Solution {
  public int jump(int[] nums) {
      int n=nums.length;
      int [] dp=new int [n];
      Arrays.fill(dp,Integer.MAX_VALUE);
      dp[0]=0;
      for(int i=0;i<n;i++){
          for(int j=1;j<=nums[i];j++){
              if(i+j<n&&dp[i]+1<dp[i+j]){
                  dp[i+j]=dp[i]+1;
              }
          }
      }
      return dp[n-1];

  }
}