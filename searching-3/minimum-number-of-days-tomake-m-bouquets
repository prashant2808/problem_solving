class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int lo=Integer.MAX_VALUE;
        int hi=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            lo=Math.min(lo,bloomDay[i]);
            hi=Math.max(hi,bloomDay[i]);
        }
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return ans;
        
    }
    boolean isPossible(int [] bloomDay,int mid,int m,int k){
        int currbouquets=0;
        int flowercount=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                flowercount++;
                if(flowercount==k){
                    currbouquets++;
                    flowercount=0;
                }
            }
            else  {
                flowercount=0;
            }
        }
        return currbouquets>=m;
    }
}
