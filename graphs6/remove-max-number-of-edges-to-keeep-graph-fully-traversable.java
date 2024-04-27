class Solution {
  public int maxNumEdgesToRemove(int n, int[][] edges) {
      Arrays.sort(edges,(a,b)->{
          return b[0]-a[0];
      });
      DisjointSet alice= new DisjointSet(n+1);
      DisjointSet bob= new DisjointSet(n+1);
      int result=0;
      for(int i=0;i<edges.length;i++){
          int type=edges[i][0];
          int u=edges[i][1];
          int v=edges[i][2];
          if(type==1){
             boolean flag= alice.unionbysize(u,v);
             if(flag){
              result++;
             }

      }
          else if(type==2){
             boolean flag= bob.unionbysize(u,v);
             if(flag)result++;

          }
          else if(type==3){
              boolean flag= alice.unionbysize(u,v);
              flag=flag& bob.unionbysize(u,v);
              if(flag)result++;
          }
      }
      boolean check;
      int countalice=0;
      int countbob=0;
      for(int i=1;i<=n;i++){
          if(alice.findpar(i)==i){
              countalice++;
          }
          if(bob.findpar(i)==i){
              countbob++;
          }
      }
      return (countalice==1&&countbob==1)?result:-1;
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
          return true;
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
      return false;
  }
}