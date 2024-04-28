

//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    private void dfs(int node,int [] vis,ArrayList<ArrayList<Integer>>adj,Stack<Integer> st)
    {
        vis[node]=1;
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(it,vis,adj,st);
          
            }
        }
        st.push(node);
    }
    private void dfs2(int node,int [] vis,ArrayList<ArrayList<Integer>>adj)
    {
        vis[node]=1;
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs2(it,vis,adj);
          
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st= new Stack<>();
        int [] vis= new int [V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)dfs(i,vis,adj,st);
        }
        ArrayList<ArrayList<Integer>> adjr= new ArrayList<>();
        for(int i=0;i<V;i++)adjr.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            vis[i]=0;
            for(int it:adj.get(i))
            {
                adjr.get(it).add(i);
            }
        }
        int scc=0;
        while(!st.isEmpty())
        {
            int node=st.pop();
            if(vis[node]==0)
            {
                scc++;
                dfs2(node,vis,adjr);
                
            }
        }
        return scc;
    }
}