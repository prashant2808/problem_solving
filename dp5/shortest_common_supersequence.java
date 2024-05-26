// tabulation
// TC-> O(m*n)
// SC -> O(m*n)

class Solution {
  public String shortestCommonSupersequence(String text1, String text2) {
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
       String res="";
       int i=0;
       int j=0;
       while(i<text1.length()&&j<text2.length()){
           if(text1.charAt(i)==text2.charAt(j)){
               res+=text1.charAt(i);
               i++;
               j++;
           }
           else {
               if(dp[i][j]==dp[i+1][j]){
                   res+=text1.charAt(i);
                   i++;
               }
               else {

                   res+=text2.charAt(j);
                   j++;
               }
           }
       }
       while(i<text1.length())res+=text1.charAt(i++);
       while(j<text2.length())res+=text2.charAt(j++);
       return res;
  }
}