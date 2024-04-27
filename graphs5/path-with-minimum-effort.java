class Solution {
  public int minimumEffortPath(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[][] dist = new int[m][n];
      for (int i = 0; i < m; i++) {
          Arrays.fill(dist[i], Integer.MAX_VALUE);
      }

      int[] drow = {-1, 0, 1, 0};
      int[] dcol = {0, 1, 0, -1};
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
      pq.offer(new int[]{0, 0, 0});

      while (!pq.isEmpty()) {
          int[] cur = pq.poll();
          int dis = cur[0];
          int row = cur[1];
          int col = cur[2];

          if (row == m - 1 && col == n - 1) return dis;

          for (int i = 0; i < 4; i++) {
              int nrow = row + drow[i];
              int ncol = col + dcol[i];

              if (nrow >= 0 && ncol >= 0 && ncol < n && nrow < m) {
                  int x = Math.max(dis, Math.abs(grid[nrow][ncol] - grid[row][col]));
                  if (x < dist[nrow][ncol]) {
                      dist[nrow][ncol] = x;
                      pq.offer(new int[]{x, nrow, ncol});
                  }
              }
          }
      }
      return 0;
  }
}
