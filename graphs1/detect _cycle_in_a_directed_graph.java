class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []vis= new boolean[V];
        boolean [] path = new boolean [V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            if(dfs(i,adj,vis,path))
            return true;
        }
        return false;
    }
    boolean dfs(int node ,ArrayList<ArrayList<Integer>> adj, boolean [] vis,boolean [] path)
    {
        vis[node]=true;
        path[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                if(dfs(it,adj,vis,path))return true;
            }
            else if(path[it])return true;
            
        }
         path[node]=false;
            return false;
    }
}
