class Solution {
  public boolean isBipartite(int[][] graph) {
      int []col= new int [graph.length];
      Arrays.fill(col,-1);
      for(int i=0;i<graph.length;i++)
      {
          if(col[i]==-1)
          if(dfs(i,graph,0,col)==false)return false;
      }
      return true;
      
  }
  boolean dfs(int node,int [][]graph,int color,int []col)
  {
      col[node]=color;
     for(int x:graph[node])
     {
          if(col[x]==-1)
          {
              if(dfs(x,graph,1-color,col)==false)return false;
          }
          else if(col[x]==color)return false;
     }
     return true;
     
  }
}