class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int [][]dist= new int [n][n];
       
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<n;j++)
          {
              if(i==j)dist[i][j]=0;
              else 
              dist[i][j]=(int)1e9;
          }

      }
      for(int i=0;i<edges.length;i++)
      {
          int u=edges[i][0];
          int v=edges[i][1];
          int wt=edges[i][2];
          dist[u][v]=wt;
          dist[v][u]=wt;
      }
       for(int k=0;k<n;k++)
       {
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
               }
           }
       }
       ArrayList<ArrayList<Integer>> res= new ArrayList<>();
       for(int i=0;i<n;i++)
       {
           res.add(new ArrayList<>());
       }
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(dist[i][j]<=distanceThreshold&&i!=j)res.get(i).add(j);
           }
       }
       int size=n;
       for(int i=0;i<n;i++)
       {
            if(res.get(i).size()<size)size=res.get(i).size();
       }
       System.out.println(size);

       int node=-1;
       for(int i=0;i<n;i++)
       {
           if(res.get(i).size()==size)node=Math.max(node,i);
       }
       return node;
  }
}