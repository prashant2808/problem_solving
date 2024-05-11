class Solution {
    
  public int rob(int[] nums) {
      if(nums.length==1)return nums[0];
       int []arr1= new int [ nums.length-1];
        int []arr2= new int [ nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            arr1[i-1]=nums[i];
        }
        for(int i=0;i<nums.length-1;i++)
        {
            arr2[i]=nums[i];
        }
        return Math.max(maxrob(arr1),maxrob(arr2));
  }
  int maxrob(int [] nums)
  {
      int ans=0;
      int prev1=nums[0];
      int prev2=0;
      for(int i=1;i<nums.length;i++)
      {
          int pick=nums[i];
          if(i>1)pick+=prev2;
          int nonpick=prev1;
          int curr=Math.max(pick,nonpick);
          prev2=prev1;
          prev1=curr;
      }
      return prev1;
       
  }
}