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
   
  public void unionbysize(int u,int v)
  {
      int ulp_u=findpar(u);
      int ulp_v=findpar(v);
      if(ulp_u==ulp_v){
          return ;
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


  }
}
class Solution {
  public int[] findRedundantConnection(int[][] edges) {
      int n=edges.length;
      int [] ans= new int [2];
      DisjointSet ds= new DisjointSet(n);
      for(int i=0;i<edges.length;i++)
      {
          int u=edges[i][0];
          int v=edges[i][1];
          if(ds.findpar(u)!=ds.findpar(v))
          {
              ds.unionbysize(u,v);
          }
          else  {
              ans[0]=u;
              ans[1]=v;
          }
      }
       
       return ans;
      
  }
}