class Solution {
  class Pair{
      int to;
      int dis;
      public Pair(int to,int dis){
          this.to=to;
          this.dis=dis;
      }
  }
  class Tuple{
      int steps;
      int node;
      int dis;
      public Tuple(int steps,int node,int dis){
          this.steps=steps;
          this.node=node;
          this.dis=dis;
      }
  }
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
      for(int i=0;i<n;i++)adj.add(new ArrayList<>());
      for(int i=0;i<flights.length;i++){
          adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
      }
      int [] dist= new int [n];
      Arrays.fill(dist,(int)1e9);
      dist[src]=0;
      Queue<Tuple> q= new ArrayDeque<>();
      q.offer(new Tuple(0,src,0));
      while(!q.isEmpty()){
          Tuple t=q.poll();
          int steps=t.steps;
          int node =t.node;
          int dis=t.dis;
          if(steps>k)continue;
          for(Pair p: adj.get(node)){
              int adjnode=p.to;
              int adjdis=p.dis;
              if(dis+adjdis<dist[adjnode]){
                  dist[adjnode]=dis+adjdis;
                  q.offer(new Tuple(steps+1,adjnode,dis+adjdis));
              }
          }

      }
      if(dist[dst]==(int)1e9)return -1;
      return dist[dst];

      
  }
}