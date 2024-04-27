class Solution {
  class Pair{
      int to;
      int weight;
      public Pair(int to,int weight){
          this.to=to;
          this.weight=weight;
      }
  }
  public int[] minimumTime(int n, int[][] edges, int[] disappear) {
      List<List<Pair>> adj= new ArrayList<>();
      for(int i=0;i<n;i++)adj.add(new ArrayList<>());
      for(int [] edge:edges){
         adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
         adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
      }
      PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->{
          return a.weight-b.weight;
      });
      int [] dist= new int [n];
      Arrays.fill(dist,Integer.MAX_VALUE);
      dist[0]=0;
      pq.offer(new Pair(0,0));
      int time=0;
      while(!pq.isEmpty()){
         Pair p= pq.poll();
         int node=p.to;
         int weight=p.weight;
         if(dist[node]<weight)continue;
         for(Pair next:adj.get(node)){
          int nextnode=next.to;
          int nextwt=next.weight;
          if(dist[nextnode]>weight+nextwt&&disappear[nextnode]>weight+nextwt){
              dist[nextnode]=weight+nextwt;
              pq.offer(new Pair(nextnode,weight+nextwt));
          }
         }
      }
      for(int i=0;i<n;i++){
          if(dist[i]==Integer.MAX_VALUE)dist[i]=-1;
      }
      return dist;
  }
}