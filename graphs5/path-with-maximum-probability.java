class Solution {
  class Pair{
      int to;
      double prob;
      public Pair(int to,double prob){
          this.to=to;
          this.prob=prob;
      }
  }
  public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
      List<List<Pair>> adj= new ArrayList<>();
      for(int i=0;i<n;i++)adj.add(new ArrayList<>());
      for(int i=0;i<edges.length;i++){
          int [] edge=edges[i];
          adj.get(edge[0]).add(new Pair(edge[1],succProb[i]));
          adj.get(edge[1]).add(new Pair(edge[0],succProb[i]));
      }
      PriorityQueue<Pair> pq= new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
      double [] prbt = new double [n];
      Arrays.fill(prbt,1e-5);
      prbt[start_node]=1.0;
      pq.offer(new Pair(start_node,1.0));
      while(!pq.isEmpty()){
         Pair p= pq.poll();
         int node =p.to;
         double nodeprob=p.prob;
         for(Pair next: adj.get(node)){
          int nextnode=next.to;
          double nextprob=next.prob;
          if(nodeprob*nextprob>prbt[nextnode]){
              prbt[nextnode]=nodeprob*nextprob;
              pq.offer(new Pair(nextnode,nodeprob*nextprob));
          }


         }
      }
      return prbt[end_node];
      
  }
}