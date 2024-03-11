class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        if(m<=1)return m;
        long lo=1;
        long hi=m;
        long ans=-1;
        while(lo<=hi)
        {
            long mid=lo+(hi-lo)/2;
            long x=1;
            for(int i=0;i<n;i++){
                x*=mid;
                if(x>m)break;
            }
            if(x==m){
                return (int)mid;
                
            }
            else if(x<m){
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        return -1;
    }
}
