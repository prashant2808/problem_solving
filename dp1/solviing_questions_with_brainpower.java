 // TABULATION 

class Solution {
  public long mostPoints(int[][] questions) {
      long [] dp= new long [questions.length];
      for(int i=questions.length-1;i>=0;i--){
          long pick=questions[i][0];
          if(i+1+questions[i][1]<questions.length){
              pick+=dp[i+1+questions[i][1]];
          }
          long nonpick=0;
          if(i+1<questions.length){
              nonpick+=dp[i+1];
          }
          dp[i]=Math.max(pick,nonpick);
      }

    return dp[0];
  }
}

/*

RECURSION +MEMOIZATION

class Solution {
  public long mostPoints(int[][] questions) {
      long [] dp= new long [questions.length];
      Arrays.fill(dp,-1);
      return helper(0,questions,dp);
  }
  long helper(int i,int [][] ques,long []dp){
      if(i>=ques.length)return 0;
      if(dp[i]!=-1)return dp[i];
      long pick=ques[i][0]+helper(i+ques[i][1]+1,ques,dp);
      long nonpick=helper(i+1,ques,dp);
      return dp[i]= Math.max(pick,nonpick);
  }
}
*/