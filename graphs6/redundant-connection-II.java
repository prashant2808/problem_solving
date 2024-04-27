public class Solution {
  public int[] findRedundantDirectedConnection(int[][] edges) {
      int n=edges.length;
      int [] indegree = new int[n+1];
      Arrays.fill(indegree,-1);
      int discardedge1=-1;
      int discardedge2=-1;
      for(int i=0;i<n;i++){
           if(indegree[edges[i][1]]==-1){
               indegree[edges[i][1]]=i;
           }
           else {
              discardedge2=i;
              discardedge1=indegree[edges[i][1]];
           }
      }
      // there can be three cases in the given problem 
      // case 1 -> there is a node with two parents 
      // case 2->there is a cycle 
      // case 3 -> there is a  node with two parents as well as cycle present in       the graph
      DisjointSet ds= new DisjointSet(n+1);
      for(int i=0;i<edges.length;i++){
          int [] edge=edges[i];
          if(i==discardedge2)continue;
          boolean flag=ds.unionbysize(edge[0],edge[1]);
          if(!flag){
              if(discardedge1==-1){
                 return edge;   // case 2  there is only cycle present in the graph
              }
              else {
                  return edges[discardedge1]; // case 3 -> there is cycle present as well as there is a node with two parents 
                  // we remove the prior edge found as there will be still cycle present if we remove the latter edge found. the prior edge will be the part of the cycle 
              }

          }
      }
      // at the last all the edges are processed and there is no cycle found so according to the question we remove the last edge found if there are multple edges satisfying the condition
      return edges[discardedge2];
      

      
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
} redundant-connection-II {
  
}
