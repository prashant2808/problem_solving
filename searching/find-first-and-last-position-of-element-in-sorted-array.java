class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]= new int [2];
        ans[0]=first(nums,0,nums.length-1,target);
        ans[1]=last(nums,0,nums.length-1,target);
        return ans;
        
    }
    int first(int [] nums,int lo,int hi,int target){
        if(lo>hi)return -1;
        int mid=lo+(hi-lo)/2;
        if(nums[mid]==target){
           if(mid>0&&nums[mid]==nums[mid-1]){
               return first(nums,lo,mid-1,target);

           }
           else return mid;
        }
        else if(nums[mid]>target){
            return first(nums,lo,mid-1,target);

        }
        else return first(nums,mid+1,hi,target);
    }
    int last(int [] nums,int lo,int hi,int target){
        if(lo>hi)return -1;
        int mid=lo+(hi-lo)/2;
        if(nums[mid]==target){
           if(mid<nums.length-1&&nums[mid]==nums[mid+1]){
               return last(nums,mid+1,hi,target);

           }
           else return mid;
        }
        else if(nums[mid]>target){
            return last(nums,lo,mid-1,target);

        }
        else return last(nums,mid+1,hi,target);
    }
}
