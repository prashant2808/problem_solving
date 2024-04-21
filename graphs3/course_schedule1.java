pclass Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      int v=numCourses;
      int n=prerequisites.length;
      ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
      for(int i=0;i<v;i++)adj.add(new ArrayList<>());
      for(int i=0;i<n;i++)
      {
          adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
      }
      int [] indeg= new int [v];
      for(int i=0;i<v;i++)
      {
          for(int it:adj.get(i))
          {
              indeg[it]++;
          }
      }
      Queue<Integer> q= new LinkedList<>();
      for(int i=0;i<v;i++)
      {
          if(indeg[i]==0)q.offer(i);
      }
      int count=0;
      while(!q.isEmpty())
      {
          int node= q.poll();
          count++;
          for(int i:adj.get(node))
          {
              indeg[i]--;
              if(indeg[i]==0)q.offer(i);
          }
      }
      return count==v;
  }
}