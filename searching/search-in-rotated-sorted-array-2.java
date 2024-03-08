class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
         int lo=0;
         int hi=n-1;
         while(lo<=hi){
             int mid=lo+(hi-lo)/2;
             if(nums[mid]==target){
                 return true;
             }
             else if(nums[mid]==nums[lo]&&nums[mid]==nums[hi]){
                 lo++;
                 hi--;
             }
             else if(nums[mid]>=nums[lo]){
                 if(nums[mid]>=target&&nums[lo]<=target){
                     hi=mid-1;
                 }
                 else {
                     lo=mid+1;
                 }

             }
             else {
                 if(nums[mid]<target&&nums[hi]>=target){
                     lo=mid+1;
                 }
                 else {
                     hi=mid-1;;
                 }

             }
         }
         return false;
        
    }
}
