 public class Solution {
    public boolean insideMat(int m, int target, int[][] matrix) {
        int l = 0, r = matrix[m].length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (matrix[m][mid] == target)
                return true;
            else if (matrix[m][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        boolean ans = false;
        while (left <= right) {
           int m = left + (right - left) / 2;
            if (matrix[m][0] == target)
                return true;
            else if (matrix[m][0] < target) {
                ans = insideMat(m, target, matrix);
                if (ans)
                    return true;
                else
                    left = m + 1;
            } else if (matrix[m][0] > target) {
                right = m - 1;
            }
        }
        return ans;
    }
 }
