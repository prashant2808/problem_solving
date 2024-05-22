package dp3;
import java.util.*;

//tabulation 
// TC-> O(n*x)
// SC-> O(x)
public class coin_combinations_II {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int sum = 1; sum <= x; sum++) {
                int skip = dp[sum];
                int pick = 0;
                if (arr[i] <= sum) {
                    pick = dp[sum - arr[i]];
                }
                dp[sum] = (pick + skip) % MOD;
            }
        }

        System.out.println(dp[x]);
    }
}
