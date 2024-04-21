class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        List<Set<Integer>> ancestors= new ArrayList<>();
        for(int i=0;i<n;i++){
         ancestors.add(new HashSet<>());
         adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            ancestors.get(edges[i][1]).add(edges[i][0]);
        }
        int [] indeg= new int [n];
        for(int i=0;i<n;i++)
        {
            for(int it:adj.get(i))
            {
                indeg[it]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indeg[i]==0)q.offer(i);
        }
        while(!q.isEmpty())
        {
            int node= q.poll();
            
            for(int i:adj.get(node))
            {
                indeg[i]--;
                if(indeg[i]==0)q.offer(i);
                ancestors.get(i).addAll(ancestors.get(node));
            }
        }
        List<List<Integer>> res= new  ArrayList<>();
        for(Set<Integer> s:ancestors){
            res.add(new ArrayList<>(s));
            Collections.sort(res.get(res.size()-1));
        }
        return res;
    }
}
