package dp2;

 // TABULATION
// TC-> O(N)
// SC -> O(N)
class Solution {
  public int numDecodings(String s) {
      int n=s.length();
      int [] dp= new int [n+1];
      dp[n]=1;
      for(int i=n-1;i>=0;i--){
          // taking one at a time
          int count1=0;
      char ch1=s.charAt(i);
      if((int)(ch1-'0')>0){
          count1= dp[i+1];
      }
      //taking two at a time 
      int count2=0;
      if(i+1<n){ 
          char ch2=s.charAt(i+1);
          if(ch1=='1'){
              count2=dp[i+2];
          }
          else if(ch1=='2'&&(ch2>='0'&&ch2<='6')){
              count2=dp[i+2];
          }
      }
      // adding both possibilities
        dp[i]=count1+count2;   
      }
      return dp[0];  
  }
}
// RECURSION + MEMOIZATION
// TC-> O(N)
// SC -> O(N) { auxiliary space }+ O(n) { stack space}
/*
class Solution {
  public int numDecodings(String s) {
      int [] dp= new int [s.length()];
      Arrays.fill(dp,-1);
      return find(0,s,dp);
  }
  int find(int i,String s,int [] dp){
      if(i>=s.length())return 1;
      if(dp[i]!=-1)return dp[i];
      //taking one at a time 
      int count1=0;
      char ch1=s.charAt(i);
      if((int)(ch1-'0')>0){
          count1=find(i+1,s,dp);
      }
      //taking two at a time 
      int count2=0;
      if(i+1<s.length()){ 
          char ch2=s.charAt(i+1);
          if(ch1=='1'){
              count2=find(i+2,s,dp);
          }
          else if(ch1=='2'&&(ch2>='0'&&ch2<='6')){
              count2=find(i+2,s,dp);
          }
      }
      return  dp[i]=count1+count2;   
  }
}
*/