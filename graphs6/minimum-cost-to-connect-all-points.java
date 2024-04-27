class Solution {
  class Edge{
      int u;
      int v;
      int wt;
      public Edge(int u,int v,int wt){
          this.u=u;
          this.v=v;
          this.wt=wt;
      }
  }
  public int minCostConnectPoints(int[][] points) {
      int V = points.length;
      List<Edge> edges = new ArrayList<>();
      for (int i = 0; i < V; i++) {
          for (int j = i + 1; j < V; j++) {
              int x1 = points[i][0];
              int y1 = points[i][1];
              int x2 = points[j][0];
              int y2 = points[j][1];
              int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);
               edges.add(new Edge(i,j,d));
          }
      }
      Collections.sort(edges,(a,b)->{
          return a.wt-b.wt;
      });
      int cost=0;
      DisjointSet ds= new DisjointSet(V+1);
      for(int i=0;i<edges.size();i++){
          int u=edges.get(i).u;
          int v=edges.get(i).v;
          int wt=edges.get(i).wt;
          if(ds.unionbysize(u,v))cost+=wt;
      }
      return cost;
  }
}
class DisjointSet{
  ArrayList<Integer> parent= new ArrayList<>(); 
  ArrayList<Integer> size= new ArrayList<>();
  public DisjointSet(int n){
      for(int i=0;i<=n;i++)
      {
          parent.add(i);
          size.add(1);
      }
  }
  public int findpar(int node)
  {
      if(node==parent.get(node))return node;
      int ulp=findpar(parent.get(node));
      parent.set(node,ulp);
      return parent.get(node);
  }
  public boolean unionbysize(int u,int v)
  {
      int ulp_u=findpar(u);
      int ulp_v=findpar(v);
      if(ulp_u==ulp_v){
          return false;
      }
      if(size.get(ulp_u)<size.get(ulp_v))
      {
          parent.set(ulp_u,ulp_v);
          size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
      }
      else
      {
          parent.set(ulp_v,ulp_u);
          size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
      }
      return true;
  }
}