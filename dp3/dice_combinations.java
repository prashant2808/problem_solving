package dp3;
import java.util.*;
public class dice_combinations {
  private static final int MOD = 1000000007;

// tabulation
// TC-> O(N)
// SC-> O(N)
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      List<Integer> prev = new ArrayList<>();
      prev.add(1);

      for (int i = 1; i <= n; i++) {
          int current = 0;
          for (int j : prev) {
              current = (current + j) % MOD;
          }
          prev.add(current);
          if (prev.size() > 6) {
              prev.remove(0);
          }
      }

      System.out.println(prev.get(prev.size() - 1));
  }
  final static int mod = (int)1e9+7;
    
  // Recursion + memoization
  // T.C: O(N)
  // S.C: O(N)
  public static int count(int n, int[] dp){
      if(n==0){
          return 1;
      }
      if(dp[n] != -1){
          return dp[n];
      }
      int ans = 0;
      for(int i=1; i<=6; i++){
          if(n-i>=0)
          ans = (ans%mod + count(n-i,dp)%mod)%mod;
      }

      return dp[n] =ans;
  }
}

 