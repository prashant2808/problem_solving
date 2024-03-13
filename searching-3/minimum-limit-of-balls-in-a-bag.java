class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo=1;
        int hi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            hi=Math.max(hi,nums[i]);
        }
        int ans=hi;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(nums,mid,maxOperations)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }    
        }
        return ans;  
    }
    boolean isPossible(int []nums,int mid,int maxOps){
        int ops=0;
        for(int i=0;i<nums.length;i++){
            int balls=nums[i];
            if(mid>balls)continue;
            balls-=mid;
            if(balls%mid==0){
                ops+=balls/mid;
            }
            else {
                ops+=balls/mid+1;
            }
            if(ops>maxOps)return false;
        }
        return ops<=maxOps;
    }
}
