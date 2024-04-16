class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj= new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
               if(i==j)continue;
               if(isConnected[i-1][j-1]==1){
                adj.get(i).add(j);
               }
            }
        }
        boolean [] vis= new boolean [n+1];
        int provinces=0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                provinces++;
                dfs(i,adj,vis);
            }
        }
        return provinces;   
    }
    void dfs(int node,List<List<Integer>> adj,boolean [] vis){
        if(vis[node])return;
        vis[node]=true;
        for(int x:adj.get(node)){
            dfs(x,adj,vis);
        }
    }
}
