package dp4;
class Solution {

  // TABULATION
   // TC-> O(n*target)
   // SC -> O(n*target)
 
  
     public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
      
        int n=nums.size();
        int [][] dp=new int [n+1][target+1];
        for(int i=0;i<=n;i++){
         Arrays.fill(dp[i],-(int)1e7);
        }
        for(int i=0;i<=n;i++)dp[i][0]=0;
        for(int i=n-1;i>=0;i--){
         for(int j=0;j<=target;j++){
             // pick
             if(j-nums.get(i)>=0)
              dp[i][j]=Math.max(dp[i][j],1+dp[i+1][j-nums.get(i)]);
             // nonpick
             dp[i][j]=Math.max(dp[i][j],dp[i+1][j]);
         }
        }
          return dp[0][target]<0?-1:dp[0][target];
     }
   
 /*
   // recursion +memoization
   TC-> O(n*target)
   SC-> O(n*target) +O(n){ stack space}
       
     int helper(int i,List<Integer> nums,int target,int [][]dp){
         if(target<0)return -(int)(1e7);
         if(i==nums.size()){
             if(target==0){
                 return 0;
             }
             return -(int)(1e7);
         }
         if(dp[i][target]!=-1)return dp[i][target];
         // pick 
         int a =1+helper(i+1,nums,target-nums.get(i),dp);
         // nonpick
         int b=helper(i+1,nums,target,dp);
         return   dp[i][target]= Math.max(a,b);
     }
     */
 }