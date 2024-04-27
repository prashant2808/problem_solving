class Solution {
  class Pair{
     int node;
     int weight;
     public Pair(int node,int weight){
         this.node=node;
         this.weight=weight;
     }
  }
 public boolean[] findAnswer(int n, int[][] edges) {
     List<List<Pair>> adj= new ArrayList<>();
     for(int i=0;i<n;i++)adj.add(new ArrayList<>());
     for(int [] edge:edges){
         adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
         adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
     }
     int [] dist= new int[n];
     Arrays.fill(dist,Integer.MAX_VALUE);
     dist[0]=0;
     PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->{
         return a.weight-b.weight;
     });
     pq.offer(new Pair(0,0));
     while(!pq.isEmpty()){
         Pair p=pq.poll();
         int node=p.node;
         int nodeweight=p.weight;
         if(dist[node]<nodeweight)continue;
         for(Pair next:adj.get(node)){
             int nextnode=next.node;
             int nextweight=next.weight;
             if(nodeweight+nextweight<dist[nextnode]){
                 dist[nextnode]=nodeweight+nextweight;
                 pq.offer(new Pair(nextnode,nodeweight+nextweight));
             }
         }
     }
     Set<String> set= new HashSet<>();
     Queue<Integer> q= new LinkedList<>();
     q.offer(n-1);
     while(!q.isEmpty()){
         int node=q.poll();
         for(Pair next:adj.get(node)){
             if(dist[node]-next.weight==dist[next.node]){
                 set.add(node+"-"+next.node);
                 q.add(next.node);
             }
         }
     }
     boolean [] ans= new boolean [edges.length];
     for(int i=0;i<edges.length;i++){
         if(set.contains(edges[i][0]+"-"+edges[i][1])||set.contains(edges[i][1]+"-"+edges[i][0]))
         ans[i]=true;
     }
     return ans;
 }
}