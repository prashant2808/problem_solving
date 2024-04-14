class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }  
        boolean [] vis= new boolean [n];
        return dfs(source,destination,adj,vis); 
    }
    boolean dfs(int src,int dest,List<List<Integer>> adj,boolean [] vis){
        if(vis[src])return false;
        if(src==dest)return true;
        vis[src]=true;
        boolean ans=false;
        for(int x:adj.get(src)){
            ans=ans|dfs(x,dest,adj,vis);
        }
       // vis[src]=false;
        return ans;
    }
}