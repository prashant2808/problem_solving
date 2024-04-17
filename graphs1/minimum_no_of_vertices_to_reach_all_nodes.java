class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res= new ArrayList<>();
        int [] indeg= new int [n];
        for(int i=0;i<edges.size();i++){
              indeg[edges.get(i).get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(indeg[i]==0)res.add(i);
        }
        return res;  
    }
}
