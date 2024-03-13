import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int lo=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<boards.size();i++){
            lo=Math.max(lo,boards.get(i));
            sum+=boards.get(i);
        }
        int hi=sum;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(boards,mid,k)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return ans;

         
    }
    static boolean isPossible(ArrayList<Integer> boards,int mid,int k){
        int currpainters=1;
        int currtime=0;
        for(int i=0;i<boards.size();i++){
            if(currtime+boards.get(i)>mid){
                currpainters++;
                currtime=boards.get(i);
            }
            else{
                currtime+=boards.get(i);
            }
        }
        return currpainters<=k;
    }
}
