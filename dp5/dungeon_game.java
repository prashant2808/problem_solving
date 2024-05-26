package dp5;

class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
      int m=dungeon.length;
      int n=dungeon[0].length;
       int [][] dp= new int [m][n];
       if(dungeon[m-1][n-1]<=0){
         dp[m-1][n-1]=-1*dungeon[m-1][n-1]+1;
       }   
       else {
          dp[m-1][n-1]=1;
       }
       for(int i=m-1;i>=0;i--){
          for(int j=n-1;j>=0;j--){
              if(i==m-1&&j==n-1)continue;
              if(i==m-1){
                   if(dungeon[i][j]<=0){
                     dp[i][j]=Math.abs(dungeon[i][j])+dp[i][j+1];
                  }
                  else{
                      dp[i][j]=Math.max(1,dp[i][j+1]-dungeon[i][j]);

                  }
              }
              else if(j==n-1){
                   if(dungeon[i][j]<=0){
                     dp[i][j]=Math.abs(dungeon[i][j])+dp[i+1][j];
                  }
                  else{
                      dp[i][j]=Math.max(1,dp[i+1][j]-dungeon[i][j]);

                  }

              }
              else {
                  if(dungeon[i][j]<=0){
                     dp[i][j]=Math.abs(dungeon[i][j])+Math.min(dp[i+1][j],dp[i][j+1]);
                  }
                  else{
                      dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);

                  }

              }
          }
       }
       return dp[0][0];
  }
}