 
//User function Template for Java

class Solution{
  static int maxSum(int N, int mat[][])
  {
      // code here
      if(N==1){
          return Math.max(mat[0][0],mat[1][0]);
      }
      int [][] dp= new int [2][N];
      Arrays.fill(dp[0],-1);
      Arrays.fill(dp[1],-1);
      return Math.max(helper(0,0,mat,dp),helper(1,0,mat,dp)) ;
  }
  static int helper(int i,int j ,int mat [][],int [][] dp){
      if(j>=mat[0].length)return 0;
      if(dp[i][j]!=-1)return dp[i][j];
      // we can have 4 ways at each column
      // 1-> select row 0 element of current column
      // 2-> select row 1 element 0f current column
      // 3-> skip current element and move to row 0 of next column
      // 4-> skip current element and move to row 1 of next column
      int a=mat[i][j]+helper(0,j+2,mat,dp);
      int b=mat[i][j]+helper(1,j+2,mat,dp);
      int c=helper(0,j+1,mat,dp);
      int d=helper(1,j+1,mat,dp);
      
      return dp[i][j]=Math.max(Math.max(a,b),Math.max(c,d));
  }
}