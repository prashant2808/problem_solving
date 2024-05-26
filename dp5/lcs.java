package dp5;

   // tabulation 
  // tc-> O(m*n)
  // sc-> O(m*n)
  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int [][] dp= new int [m+1][n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

         return dp[0][0];
    }
  }
 
 /*
 //recursion + memoization
 // tc-> O(m*n)
 // sc-> O(m*n)+ max(m,n) {stack space}
 
 class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int [][] dp= new int [m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);

         return helper(0,0,text1,text2,dp);
    }
    int helper(int i,int j,String t1,String t2,int [][] dp){
        if(i>=t1.length()||j>=t2.length())return 0;
         if(dp[i][j]!=-1)return dp[i][j];
         int ans=0;
        if(t1.charAt(i)==t2.charAt(j)){
            ans=1+helper(i+1,j+1,t1,t2,dp);
        }
        else { 
        ans=Math.max(helper(i+1,j,t1,t2,dp),helper(i,j+1,t1,t2,dp));
        }
        return dp[i][j]=ans;
    }
}
*/