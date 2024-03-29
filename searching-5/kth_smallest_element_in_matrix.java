
class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid) - 0; 
                }
            if (count < k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

     
    public static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
}
