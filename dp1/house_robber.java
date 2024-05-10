 // TABULATION  TC->O(N) SC->O(N)   {No stack space used}
 class Solution {
  public int rob(int[] nums) {
      int [] dp= new int [nums.length];
      for(int i=0;i<nums.length;i++){
          int pick=nums[i];
          if(i>=2)pick+=dp[i-2];
          int nonpick=0;
          if(i>0)nonpick+=dp[i-1];
          dp[i]=Math.max(pick,nonpick);
          System.out.println(dp[i]);
      }
      return dp[nums.length-1];
  }
   
}
/*

RECURSION +MEMOIZATION
TC->O(N) SC->O(N){extra space} +O(N){stack space}
class Solution {
  public int rob(int[] nums) {
      int [] dp= new int [nums.length];
      Arrays.fill(dp,-1);
      return helper(0,nums,dp);
  }
  int helper(int i,int [] nums,int [] dp)
  {
      if(i>=nums.length)return 0;
      if(dp[i]!=-1)return dp[i];
      int pick=nums[i]+helper(i+2,nums,dp);
      int nonpick=helper(i+1,nums,dp);
      return dp[i]= Math.max(pick,nonpick);
  }
}

RECURSION

TC->O(2^N) SC->O(N){stack space}
class Solution {
  public int rob(int[] nums) {
      
      return helper(0,nums);
  }
  int helper(int i,int [] nums)
  {
      if(i>=nums.length)return 0;
      int pick=nums[i]+helper(i+2,nums);
      int nonpick=helper(i+1,nums);
      return Math.max(pick,nonpick);
  }
}
*/