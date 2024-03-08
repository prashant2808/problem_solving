import java.util.*;
class counting2{
  public static void main(String[] args) {
    Scanner sc= new Scanner (System.in);
    int n=sc.nextInt();
    int q=sc.nextInt();
    int [] arr= new int [n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    Arrays.sort(arr);
    while(q-->0){
      int x=sc.nextInt();
      int result=search(arr,x);
      System.out.println(arr.length-result);
    }

  }
  static int search(int [] arr,int x){
    int lo=0;
    int hi=arr.length-1;
    int ans=-1;
    while(lo<=hi){ 
    int mid=(lo+hi)/2;
    if(arr[mid]>=x){
      ans=mid;
      hi=mid-1;
     }
     else lo=mid+1;
    }
    if(ans==-1)return arr.length;
    return ans;


 }
}
