 class Edge{
    int to;
    int revs;
    public Edge(int to,int revs){
        this.to=to;
        this.revs=revs;
    }
}
class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        ArrayList<Edge> [] adj= new ArrayList[n+1];
        for(int i=0;i<=n;i++)adj[i]=new ArrayList<>();
        for(int [] edge: edges){
            adj[edge[0]].add(new Edge(edge[1],0));
            adj[edge[1]].add(new Edge(edge[0],1));
        }
        Deque<int[]> dq= new ArrayDeque<>();
        boolean [][] vis= new boolean [n+1][2];
        dq.offer(new int []{src,0});
        vis[src][0]=true;
        while(!dq.isEmpty()){
            int [] currEdge =dq.pollFirst();
            int currnode=currEdge[0];
            int revs=currEdge[1];
            
            if(currnode==dst)return revs;
            for(Edge next:adj[currnode]){
                int to= next.to;
                int nextrevs=next.revs;
                
                if(!vis[to][nextrevs]){
                    vis[to][nextrevs]=true;
                    if(nextrevs==0){
                        dq.offerFirst(new int []{to,revs+nextrevs});
                    }
                    else {
                        dq.offerLast(new int []{to,revs+nextrevs});
                    }
                }
            }
        }
        return -1;
        
    }
}
