import java.util.*;
class Solution{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int [] arr= new int [n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int [] pre= new int [n+1];
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+arr[i-1];
        }
        int lo=0;
        int hi=n;
        int x=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(pre,mid,s)){
                x=mid;
                lo=mid+1;
            }
            else {
                hi=mid-1;
            }
        }
        System.out.println(x);
    }
    static boolean isPossible(int [] pre,int mid,int s){
        int i=0;
        int j=mid;
        while(j<pre.length){
            if(pre[j]-pre[i]>s)return false;
            i++;
            j++;
        }
        return true;
    }
}
