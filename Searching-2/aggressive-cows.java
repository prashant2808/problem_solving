 import java.util.*;
 class  aggresive_cows{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
      int n=sc.nextInt();
      int c=sc.nextInt();
      long [] stalls = new long [n];
      for(int i=0;i<n;i++)stalls[i]=sc.nextLong();
      Arrays.sort(stalls);
      long lo=1;
      long hi=stalls[n-1]-stalls[0];
      long ans=-1;
      while(lo<=hi){
        long mid=lo+(hi-lo)/2;
        if(isPossible(stalls,mid,c)){
          ans=mid;
          lo=mid+1;
        }
        else {
          hi=mid-1;
        }

      }
      System.out.println(ans);

    }
    
  }
  static boolean isPossible(long [] stalls,long mid,int cows){
    int cowscount=1;
    long prevpos=stalls[0];
    for(int i=1;i<stalls.length;i++){
      if(stalls[i]-prevpos>=mid){
        cowscount++;
        prevpos=stalls[i];
      }
    }
    return cowscount>=cows;
  }
 }
