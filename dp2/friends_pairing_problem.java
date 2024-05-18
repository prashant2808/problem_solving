package dp2;

 
//User function Template for Java
// SPACE OPTIMIZED
// TC-> O(N)
// SC-O(1)

class Solution
{
    static int mod=1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
       if(n<=2)return n;
        long prev1=2;  // remains single 
        long prev2=1;   // paired with friend
        long curr=-1;
        for(int i=3;i<=n;i++){
           curr=(prev1+(i-1)*prev2)%mod;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
   
         
} 

/*
// TABULATION
// TC-> O(N)
// SC-O(N)

class Solution
{
    static int mod=1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
       if(n<=2)return n;
       long [] dp= new long [n+1];
        dp[1]=1;  // remains single 
        dp[2]=2;   // paired with friend
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+(i-1)*dp[i-2])%mod;
        }
        return dp[n];
    }
   
         
} 
// RECURSION +MEMOIZATION
// TC-> O(N)
//SC ->0(N) {EXTRA SPACE } +O(N) {STACK SPACE}

class Solution
{
    static int mod=1000000007;
    public long countFriendsPairings(int n) 
    { 
       //code here
       long [] dp= new long [n+1];
       Arrays.fill(dp,-1);
       return helper(n,dp);
    }
    static long helper(int n,long []dp){
        if(n<=2)return n;
        if(dp[n]!=-1)return dp[n];
        return dp[n]= (helper(n-1,dp)+(n-1)*helper(n-2,dp))%mod;
    }
}  \
*/
 
