import java.util.*;
public class Solution {

    static int find(int[] a, int x, int y, int z, int stage, int index,Map<String,Integer> memo) {
        if (index >= a.length) {
            return Integer.MIN_VALUE;
        }
          if (stage == 3) {
            return 0; 
        }
        if (memo.containsKey(stage+"|"+index)) {
            return memo.get(stage+"|"+index);
        }
        int currentval =stage == 0?x*a[index]:stage==1?y*a[index]:z*a[index];

        int pick = currentval +find(a, x, y, z, stage + 1, index,memo);  
        int nonpick =find(a, x, y, z, stage, index + 1,memo);

        int ans = Math.max(pick,nonpick);
        memo.put(stage+"|"+index,ans);

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr= new int [n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        Map<String, Integer> memo = new HashMap<>();
        System.out.println("Maximized value: " +find(arr, x, y, z,0,0,memo));
    }
}
