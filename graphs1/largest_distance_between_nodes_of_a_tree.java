public class Solution {
    int max;
    public int solve(ArrayList<Integer> A) {
        max=0;
        int root=-1;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<A.size();i++)adj.add(new ArrayList<>());
        for(int i=0;i<A.size();i++){
            int x=A.get(i);
            if(x==-1){
                root=i;
            }
            else {
                adj.get(x).add(i);
                adj.get(i).add(x);
            }
        }
        HashSet<Integer> vis = new HashSet<>();
     // System.out.println(adj);
        dfs(root,adj,vis);
         return max; 
    } 
    int dfs(int node, List<List<Integer>> adj, HashSet<Integer> vis) {
        if(adj.get(node).size()==0)return 0;
    vis.add(node);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  
    for (int x : adj.get(node)) {
        if (!vis.contains(x))
            pq.offer(1 + dfs(x, adj, vis));
    }
    vis.remove(node);
    
    if (pq.isEmpty()) return 0;  
    
    int x1 = pq.poll();
    int x2 = pq.isEmpty() ? 0 : pq.poll(); 
    
    max = Math.max(max, x1 + x2);  
    
    return x1; // Return the maximum depth among the children
}

}
