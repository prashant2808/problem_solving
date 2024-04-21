

/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
         int [] indeg=new int [V];
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            indeg[it]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indeg[i]==0)q.offer(i);
        }
        int count=0;
        int i=0;
        while(!q.isEmpty())
        {
            int node = q.poll();
             count++;
            for(int x:adj.get(node))
            {
                
              indeg[x]--;
              if(indeg[x]==0)q.offer(x);
            }
            
        }
        return count<V;
        
    }
}
