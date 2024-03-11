class Solution {
    public int mySqrt(int x) {
        if(x<=1)return x;
        long lo=1;
        long hi=x/2;
        long ans=1;
        while(lo<=hi)
        {
            long mid=lo+(hi-lo)/2;
            if(mid*mid<=x){
                ans=mid;
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return (int)ans;
        
    }
}
