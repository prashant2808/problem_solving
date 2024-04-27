public class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
      List<int[]>[] adj = new ArrayList[n + 1];
      for (int i = 0; i <= n; i++) {
          adj[i] = new ArrayList<>();
      }
      
      for (int[] time : times) {
          int u = time[0];
          int v = time[1];
          int wt = time[2];
          adj[u].add(new int[]{v, wt});
      }

      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

      pq.offer(new int[]{0, k});

      int[] dist = new int[n + 1];
      for (int i = 1; i <= n; i++) {
          dist[i] = Integer.MAX_VALUE;
      }
      dist[k] = 0;

      while (!pq.isEmpty()) {
          int[] curr = pq.poll();
          int time = curr[0];
          int node = curr[1];

          for (int[] edge : adj[node]) {
              int neighbourNode = edge[0];
              int wt = edge[1];

              if (time + wt < dist[neighbourNode]) {
                  dist[neighbourNode] = time + wt;
                  pq.offer(new int[]{dist[neighbourNode], neighbourNode});
              }
          }  
      }

      int mx = Integer.MIN_VALUE;
      for (int i = 1; i <= n; i++) {
          if (dist[i] == Integer.MAX_VALUE) return -1;
          mx = Math.max(mx, dist[i]);
      }

      return mx;
  }
}
