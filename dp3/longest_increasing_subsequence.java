package dp3;
import java.util.*;
  //USING BINARY SEARCH
  class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> li= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int id=bsearch(li,nums[i]);
            if(id==li.size())li.add(nums[i]);
            else {
                li.set(id,nums[i]);
            }
        }
        return li.size();
        
    }
    int bsearch(ArrayList<Integer> li,int target){
        int lo=0;
        int hi=li.size()-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(li.get(mid)==target)return mid;
            else if(li.get(mid)>target){
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return lo;
    }
}
 // tabulation

/*
 class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][] dp= new int [n+1][n+1];
        // as prev vary from -1 to i-1 we have shifted  one coordinaate to handle -1 
        // taking prev+1 instead of prev
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int nonpick=dp[i+1][prev+1];
                int pick=0;
                if(prev==-1||nums[i]>nums[prev]){
                    pick=1+dp[i+1][i+1];  // in memoisaton we were taking prev as i now i+1 due to coordinate shift
                }
                dp[i][prev+1]=Math.max(pick,nonpick);
                
            }
            
        }
        return dp[0][0];
    }
 }


 // memoization


 
 class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp= new int [nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        return length(0,nums,-1,dp);
       
    }
    int length(int i,int [] nums,int prev,int [][] dp){
        if(i>=nums.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
          // pick
        int pick=0;
        if(prev==-1||nums[i]>nums[prev]){
        pick=1+length(i+1,nums,i,dp);
        }
        // nonpick
        int nonpick=length(i+1,nums,prev,dp);
        return dp[i][prev+1]= Math.max(pick,nonpick);
    }
}


  // recursion
  


 class Solution {
    public int lengthOfLIS(int[] nums) {
        return length(0,nums,-100001);
       
    }
    int length(int i,int [] nums,int prev){
        if(i>=nums.length)return 0;
        // pick
        int pick=0;
        if(nums[i]>prev){
        pick=1+length(i+1,nums,nums[i]);
        }
        
        // nonpick
        int nonpick=length(i+1,nums,prev);
        return Math.max(pick,nonpick);
    }
}
*/